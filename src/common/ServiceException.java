package com.lumen.dssh.orchestrator.common;

public class ServiceException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String technicalMessage;
	private String level;
	public ServiceException(String message) {
		super(message);
	}

	/**
	 * @return the technicalMessage
	 */
	public String getTechnicalMessage() {
		return technicalMessage;
	}
	/**
	 * @param technicalMessage the technicalMessage to set
	 */
	public void setTechnicalMessage(String technicalMessage) {
		this.technicalMessage = technicalMessage;
	}

	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
