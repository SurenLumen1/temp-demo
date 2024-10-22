package com.lumen.dssh.orchestrator.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.lumen.dssh.orchestrator.exception.AzureTokenException;
import com.lumen.dssh.orchestrator.util.StringUtility;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


@Component
public class MobileApiInterceptorHandler implements HandlerInterceptor {
	private static final String AUTHORIZATION_HEADER_NAME = "Authorization";
	private static final String AUTHORIZATION_TYPE = "Authorization-Type";
	private static final String AZURE_AD_B2C = "azure-ad-b2c";
	private static final String AZURE_TOKEN_USER = "username";
	private static final String AZURE_TOKEN = "token";
	
	private Logger logger = LogManager.getLogger(this.getClass());
	@Autowired
	private AzureTokenValidation azureTokenValidation;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		logger.info("MobileApiInterceptorHandler preHandle entry");
			if(request.getServletPath().startsWith("/consmobile/auth")) {
				String authorization = request.getHeader(AUTHORIZATION_HEADER_NAME);
				String authorization_type = request.getHeader(AUTHORIZATION_TYPE);
				if (StringUtility.isNotNullOrEmpty(authorization)) {
					if (StringUtility.isNotNullOrEmpty(authorization_type)
							&& authorization_type.equalsIgnoreCase(AZURE_AD_B2C)) {
						DecodedJWT jwt = azureTokenValidation.validateAzureToken(authorization);
						if (jwt != null) {
							String username = jwt.getClaims().get(AZURE_TOKEN_USER).asString();
							String token = jwt.getToken();
							request.setAttribute(AZURE_TOKEN, token);
							logger.info("MobileApiInterceptorHandler Azure token validated successfully for {}", username);
							request.setAttribute(CommonStrings.REQ_ATTR_USERNAME, username);
						} else {
							logger.info("MobileApiInterceptorHandler Token Invalid or Expired for URL: {}",
									request.getRequestURI());
							throw new AzureTokenException(
									ErrorCodeMapper.AzureTokenErrorMapper.TOKEN_INVALID.getErrorCode(),
									ErrorCodeMapper.AzureTokenErrorMapper.TOKEN_INVALID.getErrorMessage());
						}
					} else {
						logger.info("MobileApiInterceptorHandler Authorization Type Invalid for URL: {}",
								request.getRequestURI());
						throw new AzureTokenException(
								ErrorCodeMapper.AzureTokenErrorMapper.TOKEN_INVALID.getErrorCode(),
								ErrorCodeMapper.AzureTokenErrorMapper.TOKEN_INVALID.getErrorMessage());
					}
				} else {
					logger.info("MobileApiInterceptorHandler No token passed in header for URL: {}",
							request.getRequestURI());
					throw new AzureTokenException(
							ErrorCodeMapper.AzureTokenErrorMapper.TOKEN_MISSING.getErrorCode(),
							ErrorCodeMapper.AzureTokenErrorMapper.TOKEN_MISSING.getErrorMessage());
				}
			} else if (request.getServletPath().startsWith("/consmobile/api/sampleCall")) {
				request.setAttribute("userAuth", new Boolean(true));
			}

			return true;
		}
}
