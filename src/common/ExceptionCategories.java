/**
 * @Copyright CenturyTel, 2006.
 * This document contains proprietary and confidential information,
 * and shall not be reproduced, transferred, or disclosed to others,
 * without the prior written consent of CenturyTel.
 */
package com.lumen.dssh.orchestrator.common;

/**
 *This class is to keep different types of exception categories like SYSTEM, USER_FLOW, etc..
 */
public class ExceptionCategories {

	/** System Category */
	public static final ExceptionCategory SYSTEM = new ExceptionCategory("SYSTEM");

	/** User Flow Related */
	public static final ExceptionCategory USER_FLOW = new ExceptionCategory("USER_FLOW");

	/** User Data Related */
	public static final ExceptionCategory USER_DATA = new ExceptionCategory("USER_DATA");

	/** Informational messages */
	public static final ExceptionCategory INFORMATIONAL = new ExceptionCategory("INFORMATIONAL");
	
	/** Unknown exception */
	public static final ExceptionCategory UNKNOWN = new ExceptionCategory("UNKNOWN");

	private ExceptionCategories() {
		// Don't allow to create ExceptionCategories instance.
	}
}
