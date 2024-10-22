package com.lumen.dssh.orchestrator.util;

import com.lumen.dssh.orchestrator.common.ExceptionCode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BusinessException extends Exception{
    private static final long serialVersionUID = 1L;
    private ExceptionCode code;
    private boolean logged = false;
    private String technicalMessage;

    private static final Logger logger = LogManager.getLogger();

    private BusinessException() {
        // Don't allow to create exception with out any params
    }

    public BusinessException(String method,String message) {
        super(message);
        logger.error("BusinessException in "+method +" : "+message);
    }

    public BusinessException(ExceptionCode code, String message) {
        super(message);
        this.code = code;
        this.logged = false;
    }

    public BusinessException(ExceptionCode code) {
        super(code.getDesc());
        this.code = code;
        this.logged = false;
    }

    public ExceptionCode getCode() {
        return code;
    }

    public String getTechnicalMessage() {
        if (technicalMessage == null || technicalMessage.trim().length() == 0) {
            return getMessage();
        } else {
            return technicalMessage;
        }
    }

    /**
     * This can be used to set a technical message for the exception. This would be some message
     * that you want to log but not show to a user.
     *
     * @param technicalMessage the technicalMessage to set
     */
    public void setTechnicalMessage(String technicalMessage) {
        this.technicalMessage = technicalMessage;
    }

}
