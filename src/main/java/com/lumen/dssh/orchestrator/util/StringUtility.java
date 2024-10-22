package com.lumen.dssh.orchestrator.util;



public class StringUtility {
 	private StringUtility(){

	}
	public static boolean isNotNullOrEmpty(String str){
		return (str != null && str.trim().length() > 0);
	}

	/**
	 * Returns empty string if string is null
	 *
	 * @param string - value
	 * @return - ""
	 */
	public static String checkNullOrEmpty(String string) {
		if (string != null && !string.isEmpty()) {
			return string.trim();
		}
		return "";
	}

	/**
	 * Check whether value is null or empty
	 *
	 * @param string - value
	 * @return - true / false
	 */
	public static boolean isNullOrEmpty(String string) {
		if (string == null) {
			return true;
		}
		return string.trim().isEmpty();
	}

}

