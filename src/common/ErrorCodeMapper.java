package com.lumen.dssh.orchestrator.common;

/**
 * This class will wrap the different error codes for messages used in the service.
 */
public final class ErrorCodeMapper {

    private ErrorCodeMapper(){
        //Avoid object creation
    }

    //Below enum is the wrapper for the messages for AzureTokenValidation
    public enum AzureTokenErrorMapper {
        AUDIENCE_DOES_NOT_MATCH("AZ-TKN-001", "Azure Token not valid as audience does not match."),
        ISSUER_DOES_NOT_MATCH("AZ-TKN-002", "Azure Token not valid as issuer does not match."),
        TOKEN_EXPIRED("AZ-TKN-003", "Azure Token expired!"),
        TOKEN_MISSING("AZ-TKN-004", "No token passed in header"),
        TOKEN_INVALID("AZ-TKN-005", "Token Invalid or Expired"),
        UNKNOWN_ERROR("AZ-TKN-006", "Unknown Error"),
    	ACR_DOES_NOT_MATCH("AZ-TKN-007", "Azure Token not valid as acr does not match");

        private final String errorCode;
        private final String errorMessage;
        AzureTokenErrorMapper(String errorCode, String errorMessage) {
            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }

        public String getErrorCode() {
            return errorCode;
        }

        public String getErrorMessage() {
            return errorMessage;
        }

        public static AzureTokenErrorMapper getTypeOnErrorMessage(String errorMessage){
            for (AzureTokenErrorMapper azureTokenErrorMapper : AzureTokenErrorMapper.values()) {
                if(errorMessage.equalsIgnoreCase(azureTokenErrorMapper.getErrorMessage())){
                    return azureTokenErrorMapper;
                }
            }
            return AzureTokenErrorMapper.UNKNOWN_ERROR;
        }
    }



}
