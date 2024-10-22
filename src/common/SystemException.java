package com.lumen.dssh.orchestrator.common;

public class SystemException extends Exception {

	private static final long serialVersionUID = 1L;
	private ExceptionCode code;
	private String technicalMessage;
	private boolean logged = false;

	@SuppressWarnings("unused")
	private SystemException() {
		// Don't allow to create exception with out any params
	}

	public SystemException(ExceptionCode code, String message) {
		super(message);
		this.code = code;
		this.logged = false;
	}

	public SystemException(ExceptionCode code) {
		super(code.getDesc());
		this.code = code;
		this.logged = false;
	}

	public SystemException(String message) {
		super(message);
		this.code = ExceptionCodes.GENERIC;
		this.logged = false;
	}

	public SystemException(int errorCode, String message) {
		super(message);
		this.code = ExceptionCodes.getExceptionForNumber(errorCode, false);
		this.logged = false;
	}

	public SystemException(int errorCode) {
		super(ExceptionCodes.getExceptionForNumber(errorCode, false).getDesc());
		this.code = ExceptionCodes.getExceptionForNumber(errorCode, false);
		this.logged = false;
	}

	/**
	 * Get the errorCode.
	 * 
	 * @return Returns the errorCode.
	 */
	public ExceptionCode getCode() {
		return code;
	}

	public void setErrorCode(ExceptionCode code) {
		this.code = code;
	}

	public ExceptionCategory getCategory() {
		return getCode().getCategory();
	}

	@Override
	public String getMessage() {
		String msg = super.getMessage();
		if (msg.length() > 0) {
			return msg;
		} else if (getCode() != null) {
			return getCode().getDesc();
		}
		return "";
	}


	public String getUserMessage() {
		String msg = super.getMessage();
		if (msg.length() > 0) {
			Throwable tmpThrowable = this;
			while (tmpThrowable.getCause() != null && tmpThrowable != tmpThrowable.getCause()) {
				tmpThrowable = tmpThrowable.getCause();
			}
			if (this == tmpThrowable) {
				return msg;
			}
			return tmpThrowable.getMessage();
		} else if (getCode() != null) {
			return getCode().getDesc();
		}
		return "";
	}

	public String getTechnicalMessage() {

		if (technicalMessage == null || technicalMessage.trim().length() == 0) {
			return getMessage();
		} else {
			return technicalMessage;
		}
	}
	public void setTechnicalMessage(String technicalMessage) {
		this.technicalMessage = technicalMessage;
	}

	public void setlogged(boolean aboolean) {
		this.logged = aboolean;
	}

	public boolean islogged() {
		return this.logged;
	}
}
