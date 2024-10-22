package com.lumen.dssh.orchestrator.common;

import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkException;
import com.auth0.jwk.JwkProvider;
import com.auth0.jwk.UrlJwkProvider;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.lumen.dssh.orchestrator.exception.AzureTokenException;
import com.lumen.dssh.orchestrator.handler.AzureAccessorHandler;
import com.lumen.dssh.orchestrator.model.AzureOIDCMetaDataResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.interfaces.RSAPublicKey;
import java.util.Calendar;

@Component
public class AzureTokenValidation {

    @Autowired
    AzureAccessorHandler azureAccessorHandler;

    @Value("${azure.mobile.policyid}")
    private String policyId;

    @Value("${azure.mobile.clientid}")
    private String clientId;

    @Value("${azure.mobile.baseurl}")
    private String endpoint;

    @Value("${azure.mobile.jwks.uri.resource}")
    private String jwks_uri_resource;

    @Value("${azure.mobile.tenantid}")
    private String tenantId;

    private static final String BEARER = "Bearer ";

    private static final Logger logger = LogManager.getLogger();

    public DecodedJWT validateAzureToken( String token) throws Exception {
    	logger.debug("Entered validateAzureToken method in AzureTokenValidation");
        DecodedJWT jwt = null;
        String azureToken;
        String jwksUri = getAzureJwksUrl();
        String issuer = getAzureAdB2CMobileIssuer();
        AzureOIDCMetaDataResponse azureOIDCMetaDataResponse;
        if (token.startsWith(BEARER)) {
            azureToken = token.substring(7, token.length());
        } else {
            azureToken = token;
        }
        try {
            if (azureToken != null) {
                logger.info("AzureToken = "+azureToken);
                azureOIDCMetaDataResponse = callOIDCMetaDataEndpoint();
                if (null != azureOIDCMetaDataResponse) {
                    jwksUri = azureOIDCMetaDataResponse.getJwksUri();
                    issuer = azureOIDCMetaDataResponse.getIssuer();
                }
                jwt = JWT.decode(azureToken);
                verifyJWTSignature(jwt, jwksUri);
                logger.debug(" validateAzureToken ClientId from properties = "+clientId);
                if (!jwt.getAudience().contains(clientId)) {//"70d4a80b-2e55-4c4c-9833-92faf248e576" for TEST
                    logger.error(" validateAzureToken Client Id doesn't match");
                    throw new AzureTokenException(
                            ErrorCodeMapper.AzureTokenErrorMapper.AUDIENCE_DOES_NOT_MATCH.getErrorCode(),
                            ErrorCodeMapper.AzureTokenErrorMapper.AUDIENCE_DOES_NOT_MATCH.getErrorMessage());
                }
                if (!jwt.getIssuer().contains(issuer)) {
                    logger.error("validateAzureToken Issuer doesn't match with the JWT issuer");
                    throw new AzureTokenException(
                            ErrorCodeMapper.AzureTokenErrorMapper.ISSUER_DOES_NOT_MATCH.getErrorCode(),
                            ErrorCodeMapper.AzureTokenErrorMapper.ISSUER_DOES_NOT_MATCH.getErrorMessage());
                }
                
                //Check if token Environment matches
                if (jwt.getClaims().get("acr") != null
						&& !jwt.getClaims().get("acr").asString().equalsIgnoreCase(policyId)) {
                	 logger.error("validateAzureToken ACR doesn't match with the JWT acr");
					 throw new AzureTokenException(
	                            ErrorCodeMapper.AzureTokenErrorMapper.ACR_DOES_NOT_MATCH.getErrorCode(),
	                            ErrorCodeMapper.AzureTokenErrorMapper.ACR_DOES_NOT_MATCH.getErrorMessage());
				}

                // Check expiration
                if (jwt.getExpiresAt().before(Calendar.getInstance().getTime())) {
                    logger.error("validateAzureToken Token is expired");
                    throw new AzureTokenException(
                            ErrorCodeMapper.AzureTokenErrorMapper.TOKEN_EXPIRED.getErrorCode(),
                            ErrorCodeMapper.AzureTokenErrorMapper.TOKEN_EXPIRED.getErrorMessage());
                }

            }
        } catch (Exception be) {
            logger.error("validateAzureToken Exception: "+be.getMessage());
            throw new AzureTokenException(
                    ErrorCodeMapper.AzureTokenErrorMapper.getTypeOnErrorMessage(be.getMessage()).getErrorCode(),
                    be.getMessage());
        }
        return jwt;
    }

    private AzureOIDCMetaDataResponse callOIDCMetaDataEndpoint() {
        AzureOIDCMetaDataResponse azureOIDCMetaDataResponse = null;
        try {
            azureOIDCMetaDataResponse  = azureAccessorHandler.getMetaDataFromOIDC();
            logger.debug("AzureTokenValidation callOIDCMetaDataEndpoint: "+azureOIDCMetaDataResponse.toString());
        } catch (Exception e) {
            logger.error("AzureTokenValidation callOIDCMetaDataEndpoint Exception: "+e.getMessage());
            throw e;
        }
        return azureOIDCMetaDataResponse;
    }

    private void verifyJWTSignature(DecodedJWT jwt, String jkwsUri) throws Exception {
        JwkProvider provider;
        Jwk jwk;
        Algorithm algorithm;
        try {
            provider = new UrlJwkProvider(new URL(jkwsUri));
            jwk = provider.get(jwt.getKeyId());
            algorithm = Algorithm.RSA256((RSAPublicKey) jwk.getPublicKey(), null);
            algorithm.verify(jwt);
        } catch (MalformedURLException exp) {
            logger.error("AzureTokenValidation verifyJWTSignature MalformedURLException: " + exp.getMessage());
            throw exp;
        } catch (JwkException exp) {
            logger.error("AzureTokenValidation verifyJWTSignature JwkException: " + exp.getMessage());
            throw exp;
        } catch (SignatureVerificationException exp) {
            logger.error("AzureTokenValidation verifyJWTSignature SignatureVerificationException: " + exp.getMessage());
            throw exp;
        }
    }


    /**
     * https://signin-test.centurylink.com/5f480fa4-d96f-4b50-a9d7-8c1e362378cc/v2.0/ in TEST
     * @return
     */
    private String getAzureAdB2CMobileIssuer() {
        logger.debug("AzureTokenValidation getAzureAdB2CMobileIssuer AZURE_ENDPOINT from properties: "+ endpoint);
        logger.debug("AzureTokenValidation getAzureAdB2CMobileIssuer AZURE_TENANT_ID from properties: "+ tenantId);
        return endpoint + tenantId + "/v2.0/";
    }

    /**
     * // TEST URL:https://signin-test.centurylink.com/5f480fa4-d96f-4b50-a9d7-8c1e362378cc/b2c_1a_ctl_consumer_oidc/discovery/v2.0/keys
     * @return
     */
    private String getAzureJwksUrl() {
        logger.debug("AzureTokenValidation getAzureJwksUrl AZURE_ENDPOINT from properties: "+ endpoint);
        logger.debug("AzureTokenValidation getAzureJwksUrl AZURE_TENANT_ID from properties: "+ tenantId);
        logger.debug("AzureTokenValidation getAzureJwksUrl AZURE_POLICY_ID from properties: "+ policyId);
        logger.debug("AzureTokenValidation getAzureJwksUrl AZURE_JWKS_URI_RESOURCE from properties: "+ jwks_uri_resource);
        return endpoint + tenantId + "/" + policyId + jwks_uri_resource;
    }

    public AzureAccessorHandler getAzureAccessorHandler() {
        return azureAccessorHandler;
    }

    public void setAzureAccessorHandler(AzureAccessorHandler azureAccessorHandler) {
        this.azureAccessorHandler = azureAccessorHandler;
    }
}
