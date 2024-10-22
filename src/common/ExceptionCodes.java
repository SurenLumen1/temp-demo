/**
 * @Copyright CenturyTel, 2006.
 * This document contains proprietary and confidential information,
 * and shall not be reproduced, transferred, or disclosed to others,
 * without the prior written consent of CenturyTel.
 */
package com.lumen.dssh.orchestrator.common;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is to define all exception codes.
 */
public class ExceptionCodes {

	private static HashMap<String, ExceptionCode> systemExceptionMap;
	private static HashMap<String, ExceptionCode> businessExceptionMap;

	public static final  String GENERIC_SYSTEM_OUTAGE_MESSAGE = "We are currently experiencing a system outage.  Please try your request later.";
	public static final  String GENERIC_SYSTEM_FUNCTION_MESSAGE = "We are currently unable to provide this function.  Please try again later";
	
	public static final  String DVAR_GENERIC_PROBLEM_MESSAGE = "We apologize for the inconvenience, but we cannot save your updates at this time. Please try again later.";
	public static final  String DVAR_NOTIFICATION_GET = "We apologize for this inconvenience, but we are unable to retrieve your notification preferences at this time. Please try again later.";
	public static final String DVAR_BACKEND_SYSTEM_FAILURE_MESSAGE = "We are currently unable to retrieve the account data needed to complete your request as one or more of our systems are currently unavailable. Please try again later.";
	public static final String DVAR_INVALID_ACCOUNT_MESSAGE = "The account number provided is not valid.";
	
	public static final  String SYSTEM_TIMEOUT_MESSAGE = "Request/Connection has timed out.  Please try your request later.";

	public static final String NOT_ONLINE_ACCOUNT_MESSAGE = "This account number can not be accessed online.";

	// USER_DATA ExceptionCodes - These should be more functional errors such as the user entered
	// invalid data, or perhaps the users data is such that they can not do what they want to
	
	public static final ExceptionCode INVALID_ACCOUNT_ID_EXCEPTION_CD = new ExceptionCode("INVALID_ACCOUNT_ID_EXCEPTION_CD",
			"The Account Number provided is not valid for Century Link. ", ExceptionCategories.USER_DATA);

	// note i switched number for id so you could distinguish even tho they are in essence the same
	// thing
	public static final ExceptionCode CTL_INVALID_BAN = new ExceptionCode("CTL_INVALID_BAN", DVAR_INVALID_ACCOUNT_MESSAGE,
			ExceptionCategories.USER_DATA);

	public static final ExceptionCode INVALID_USER_ID_EXCEPTION = new ExceptionCode("INVALID_USER_ID_EXCEPTION", "This is not a valid User Id",
			ExceptionCategories.USER_DATA);

	public static final ExceptionCode USER_LOGIN_ID_TAKEN = new ExceptionCode("USER_LOGIN_ID_TAKEN",
			"This User login Id is already taken. Please try a different User login Id", ExceptionCategories.USER_DATA);

	public static final ExceptionCode USER_LOGIN_ID_NOT_FOUND = new ExceptionCode("USER_LOGIN_ID_NOT_FOUND", "This login name was not found in our system.",
			ExceptionCategories.USER_DATA);

	public static final ExceptionCode FORGOT_LOGIN_ID_NOT_FOUND = new ExceptionCode("FORGOT_LOGIN_ID_NOT_FOUND", "No logins found for Given given inputs.",
			ExceptionCategories.USER_DATA);

	public static final ExceptionCode ACCOUNT_ALREADY_REGISTERED = new ExceptionCode("ACCOUNT_ALREADY_REGISTERED",
			"ACCOUNT_ALREADY_REGISTERED", ExceptionCategories.USER_DATA);
	
	public static final ExceptionCode CRIS_CONVERTED_ACCOUNT_ALREADY_REGISTERED = new ExceptionCode("CRIS_CONVERTED_ACCOUNT_ALREADY_REGISTERED",
			"CRIS_CONVERTED_ACCOUNT_ALREADY_REGISTERED", ExceptionCategories.USER_DATA);

	public static final ExceptionCode ACCOUNT_IS_BUSINESS = new ExceptionCode("ACCOUNT_IS_BUSINESS",
			"ACCOUNT_IS_BUSINESS", ExceptionCategories.USER_DATA);

	public static final ExceptionCode ACCOUNT_NOT_REGISTERABLE = new ExceptionCode("ACCOUNT_NOT_REGISTERABLE",
			"Supplied Account is not available for online registration.", ExceptionCategories.USER_DATA);

	public static final ExceptionCode ACCOUNT_WAS_NOT_FOUND = new ExceptionCode("ACCOUNT_WAS_NOT_FOUND",
			"The information for this account is unavailable.", ExceptionCategories.USER_DATA);
	
	public static final ExceptionCode ACCOUNT_IS_IN_COLLECTIONS = new ExceptionCode("ACCOUNT_IS_IN_COLLECTIONS",
			NOT_ONLINE_ACCOUNT_MESSAGE, ExceptionCategories.USER_DATA);

	public static final ExceptionCode ACCOUNT_IS_DISCONNECTED = new ExceptionCode("ACCOUNT_IS_DISCONNECTED", NOT_ONLINE_ACCOUNT_MESSAGE,
			ExceptionCategories.USER_DATA);

	public static final ExceptionCode ACCOUNT_BLOCKED_EXCEPTION_CD = new ExceptionCode("ACCOUNT_BLOCKED_EXCEPTION_CD",
			NOT_ONLINE_ACCOUNT_MESSAGE, ExceptionCategories.USER_DATA);

	public static final ExceptionCode ACCOUNT_DISABLED_EXCEPTION_CD = new ExceptionCode("ACCOUNT_DISABLED_EXCEPTION_CD",
			NOT_ONLINE_ACCOUNT_MESSAGE, ExceptionCategories.USER_DATA);
		
	public static final ExceptionCode CUSTOMER_IDM_PROFILE_NOT_FOUND = new ExceptionCode("CUSTOMER_IDM_PROFILE_NOT_FOUND",
			"The user profile data requested was not found", ExceptionCategories.USER_DATA);

	public static final ExceptionCode PROFILE_LOADING_EXCEPTION = new ExceptionCode("PROFILE_LOADING_EXCEPTION",
			"We are unable to load requested profile. Please contact Customer Support.", ExceptionCategories.USER_DATA);

	public static final ExceptionCode INVALID_CUST_CODE_EXCEPTION = new ExceptionCode("INVALID_CUST_CODE_EXCEPTION", "The value entered was not valid",
			ExceptionCategories.USER_DATA);
	
	public static final ExceptionCode ENTITY_NOT_AUTHENTICATED = new ExceptionCode("ENTITY_NOT_AUTHENTICATED",
			"Authentication for the supplied customer account failed.", ExceptionCategories.USER_DATA);

	public static final ExceptionCode CTL_BAN_NOT_FOUND_CUSREPO = new ExceptionCode("CTL_BAN_NOT_FOUND_CUSREPO", ExceptionCategories.USER_DATA);

	public static final ExceptionCode BIZ_REGISTRATION_TOOK_TOO_LONG = new ExceptionCode("BIZ_REGISTRATION_TOOK_TOO_LONG",
			"UserProfile and Business Organization was successfully created. Account will be added with delay", ExceptionCategories.INFORMATIONAL);


	
	// SYSTEM ExceptionCodes - These should be more system errors such as the backend system is down
	// of something unexpected has happened. experiencing
	// Note you might want to consider loading these messages from PropertyManager that way the
	// messages can come from an
	// external source

	public static final ExceptionCode INVALID_PARAMETER_EXCEPTION = new ExceptionCode("INVALID_PARAMETER_EXCEPTION", GENERIC_SYSTEM_FUNCTION_MESSAGE,
			ExceptionCategories.SYSTEM);

	public static final ExceptionCode IDM_SYSTEM_EXCEPTION = new ExceptionCode("IDM_SYSTEM_EXCEPTION", GENERIC_SYSTEM_OUTAGE_MESSAGE,
			ExceptionCategories.SYSTEM);

	public static final ExceptionCode EDOCS_EXCEPTION_CD = new ExceptionCode("EDOCS_EXCEPTION_CD", GENERIC_SYSTEM_OUTAGE_MESSAGE, ExceptionCategories.SYSTEM);

	public static final ExceptionCode W3L_REMOTE_EXCEPTION_CD = new ExceptionCode("W3L_REMOTE_EXCEPTION_CD", GENERIC_SYSTEM_OUTAGE_MESSAGE,
			ExceptionCategories.SYSTEM);

	public static final ExceptionCode W3L_DB_EXCEPTION_CD = new ExceptionCode("W3L_DB_EXCEPTION_CD", GENERIC_SYSTEM_OUTAGE_MESSAGE, ExceptionCategories.SYSTEM);

	public static final ExceptionCode W3L_SYSTEM_EXCEPTION_CD = new ExceptionCode("W3L_SYSTEM_EXCEPTION_CD", GENERIC_SYSTEM_OUTAGE_MESSAGE,
			ExceptionCategories.SYSTEM);

	public static final ExceptionCode CTL_CALL_TO_CUST_REGSTRY_FAILD = new ExceptionCode("CTL_CALL_TO_CUST_REGSTRY_FAILD", GENERIC_SYSTEM_OUTAGE_MESSAGE,
			ExceptionCategories.SYSTEM);

	public static final ExceptionCode CTL_FAILD_TO_CALL_ENSEMBLE = new ExceptionCode("CTL_FAILD_TO_CALL_ENSEMBLE", GENERIC_SYSTEM_OUTAGE_MESSAGE,
			ExceptionCategories.SYSTEM);
	public static final ExceptionCode DOCS_SYSTEM_EXCEPTION = new ExceptionCode("DOCS_SYSTEM_EXCEPTION", GENERIC_SYSTEM_OUTAGE_MESSAGE,
			ExceptionCategories.SYSTEM);

	public static final ExceptionCode IDM_SYSTEM_EXCEPTION_CREATE_PROFILE = new ExceptionCode("IDM_SYSTEM_EXCEPTION_CREATE_PROFILE",
			GENERIC_SYSTEM_OUTAGE_MESSAGE, ExceptionCategories.SYSTEM);

	public static final ExceptionCode IDM_SYSTEM_EXCEPTION_GET_PROFILE = new ExceptionCode("IDM_SYSTEM_EXCEPTION_GET_PROFILE", GENERIC_SYSTEM_OUTAGE_MESSAGE,
			ExceptionCategories.SYSTEM);

	public static final ExceptionCode INTEC_TRANSACTION_EXCEPTION = new ExceptionCode("INTEC_TRANSACTION_EXCEPTION", GENERIC_SYSTEM_OUTAGE_MESSAGE,
			ExceptionCategories.SYSTEM);
	public static final ExceptionCode WEB_SERVICE_CLIENT_CALL_FAILURE = new ExceptionCode("WEB_SERVICE_CLIENT_CALL_FAILURE", GENERIC_SYSTEM_OUTAGE_MESSAGE,
			ExceptionCategories.SYSTEM);
	public static final ExceptionCode REST_SERVICE_CLIENT_CALL_FAILURE = new ExceptionCode("WEB_SERVICE_CLIENT_CALL_FAILURE", GENERIC_SYSTEM_OUTAGE_MESSAGE,
			ExceptionCategories.SYSTEM);
	
	// This indicates that the users data is in an invalid condition.
	// While it is a data issues it is also a system issue because
	// the system should be coded such that this condition should not occur.
	public static final ExceptionCode MAJOR_BUSINESS_ACCOUNT_EXCEPTION_CD = new ExceptionCode("MAJOR_BUSINESS_ACCOUNT_EXCEPTION_CD",
			GENERIC_SYSTEM_FUNCTION_MESSAGE, ExceptionCategories.SYSTEM);

	public static final ExceptionCode BACKEND_APP_IS_DOWN = new ExceptionCode("BACKEND_APP_IS_DOWN", GENERIC_SYSTEM_OUTAGE_MESSAGE,
			ExceptionCategories.SYSTEM);

	public static final ExceptionCode APPLICATION_LEGACY_MYACCOUNT_IS_DOWN = new ExceptionCode("APPLICATION_LEGACY_MYACCOUNT_IS_DOWN",
			GENERIC_SYSTEM_OUTAGE_MESSAGE, ExceptionCategories.SYSTEM);

	public static final ExceptionCode APPLICATION_PAYMENT_IS_DOWN = new ExceptionCode("APPLICATION_PAYMENT_IS_DOWN",
			GENERIC_SYSTEM_OUTAGE_MESSAGE, ExceptionCategories.SYSTEM);

	/** Generic Code */
	public static final ExceptionCode GENERIC = new ExceptionCode("GENERIC", GENERIC_SYSTEM_FUNCTION_MESSAGE, ExceptionCategories.SYSTEM);
	public static final ExceptionCode INVALID_ADD_NEW_USER = new ExceptionCode("INVALID_ADD_NEW_USER",
			"Could not add a new user possible reason insufficient data", ExceptionCategories.SYSTEM);

	public static final ExceptionCode NO_ACCOUNTS_USER = new ExceptionCode("NO_ACCOUNTS_USER",
			"No accounts are associated to the organization please contact your Org admin", ExceptionCategories.INFORMATIONAL);
	
	public static final ExceptionCode NO_SEC_QUES_ON_PROFILE = new ExceptionCode("NO_SEC_QUES_ON_PROFILE",
			"Insufficient data on profile to reset password. Please contact 888-888-8888", ExceptionCategories.USER_DATA);

	public static final ExceptionCode USER_ID_LOGIN_DOESNT_MATCH = new ExceptionCode("USER_ID_LOGIN_DOESNT_MATCH",
			"UserId and LoginName where provided but does not belong to same user", ExceptionCategories.USER_DATA);

	public static final ExceptionCode PASSWD_MAX_LENGTH = new ExceptionCode("PASSWD_MAX_LENGTH", "Password cannot be longer than 32 characters",
			ExceptionCategories.USER_DATA);

	public static final ExceptionCode PASSWD_MIN_LENGTH = new ExceptionCode("PASSWD_MIN_LENGTH", "Password must be at least 8 characters long",
			ExceptionCategories.USER_DATA);

	public static final ExceptionCode PASSWD_REPEATING_CHAR = new ExceptionCode("PASSWD_REPEATING_CHAR",
			"Sorry, your new password isn't allowed to contain a character that repeats consecutively 3 or more times (ex. aaaBCD18 or ABC111de). Please try again.", ExceptionCategories.USER_DATA);

	public static final ExceptionCode PASSWD_REQUIRED_CHAR = new ExceptionCode("PASSWD_REQUIRED_CHAR",
			"Password does not have 'RequiredCharacterSets' (minimum required) characters", ExceptionCategories.USER_DATA);
	public static final ExceptionCode PAPERLESS_PREFERENCE_EXCEPTION = new ExceptionCode("PAPERLESS_PREFERENCE_EXCEPTION", "Sorry - we were unable to save your changes. We're experiencing temporary technical difficulties. Please try again in a few minutes.", ExceptionCategories.SYSTEM);
	public static final ExceptionCode PASSWD_ILLEGAL_CHAR = new ExceptionCode("PASSWD_ILLEGAL_CHAR", "Sorry, the new password you've entered contains a special character that isn't allowed. Please try again.  Valid special characters include ! @ ^ & * # $ % ( ) + ~ and Invalid special characters include _ = ` { } | [ ] \\ : \" ; \' < > ? , . /",
			ExceptionCategories.USER_DATA);
	public static final ExceptionCode PASSWD_RESEMBLANCE_CHAR = new ExceptionCode("PASSWD_RESEMBLANCE_CHAR",
			"The new password you're trying to use is too similar to other information on your profile (user name, first name, last name, or email address). Please try again.", ExceptionCategories.USER_DATA);

	public static final ExceptionCode PASSWD_ATLEAST_ONE_CHAR = new ExceptionCode("PASSWD_ATLEAST_ONE_CHAR",
			"The new password you've entered doesn't follow our password guidelines.  Please try again.", ExceptionCategories.USER_DATA);
	public static final ExceptionCode NEW_PWD_OLD_PWD_SAME = new ExceptionCode("NEW_PWD_OLD_PWD_SAME", "New password cannot be the same as the current password.",
			ExceptionCategories.USER_DATA);

	public static final ExceptionCode INVALID_HINT_FORMAT = new ExceptionCode("INVALID_HINT_FORMAT", "Invalid hint question format, must be numeric",
			ExceptionCategories.USER_DATA);
	public static final ExceptionCode INVALID_USERID_FORMAT = new ExceptionCode("INVALID_USERID_FORMAT", "UserID if provided, should be numeric",
			ExceptionCategories.USER_DATA);
	public static final ExceptionCode INVALID_HINT_QUESTION = new ExceptionCode("INVALID_HINT_QUESTION", "Hint Question is not valid",
			ExceptionCategories.USER_DATA);
	public static final ExceptionCode USERID_NOT_FOUND = new ExceptionCode("USERID_NOT_FOUND", "User Id does not exist", ExceptionCategories.USER_DATA);
	public static final ExceptionCode LOGIN_NOT_FOUND = new ExceptionCode("LOGIN_NOT_FOUND", "Invalid Input Data: User Login Name does not exist",
			ExceptionCategories.USER_DATA);
	public static final ExceptionCode GROUP_ALREADY_ASSOCIATED = new ExceptionCode("GROUP_ALREADY_ASSOCIATED", "Group Already associated to the User",
			ExceptionCategories.USER_DATA);
	public static final ExceptionCode GROUP_DOESNT_EXIST = new ExceptionCode("GROUP_DOESNT_EXIST", "No group information exist", ExceptionCategories.USER_DATA);
	public static final ExceptionCode PASSWD_LOGIN_MISMATCH = new ExceptionCode("PASSWD_LOGIN_MISMATCH", "Current password and/or login do not matchs",
			ExceptionCategories.USER_DATA);

	public static final ExceptionCode INVALID_IDENTITY_STATUS = new ExceptionCode("INVALID_IDENTITY_STATUS",
			"IdentityStatus if provided, should be either 0 or 1", ExceptionCategories.USER_DATA);
	public static final ExceptionCode LOGIN_NAME_MIN_LENGTH = new ExceptionCode("LOGIN_NAME_LENGTH", "Login name must be at least 6 characters long",
			ExceptionCategories.USER_DATA);

	public static final ExceptionCode INVALID_EMAIL_ID = new ExceptionCode("INVALID_EMAIL_ID", "Given Email id is not valid", ExceptionCategories.USER_DATA);
	public static final ExceptionCode LOGIN_NAME_MAX_LENGTH = new ExceptionCode("LOGIN_NAME_MAX_LENGTH", "Login Name can not have more than 32 characters",
			ExceptionCategories.USER_DATA);
	public static final ExceptionCode LOGIN_NAME_INVALID_CHAR = new ExceptionCode("LOGIN_NAME_INVALID_CHAR",
			"Login name contains characters that are not allowed.  Confirm that no special characters or uppercase characters are being used",
			ExceptionCategories.USER_DATA);
	public static final ExceptionCode LOGIN_NAME_INVALID_SPECIAL_CHAR = new ExceptionCode("LOGIN_NAME_INVALID_SPECIAL_CHAR",
			"LoginName should not contain any special character except '_'", ExceptionCategories.USER_DATA);
	public static final ExceptionCode HINT_QA_MISMATCH = new ExceptionCode("HINT_QA_MISMATCH", "Hint Question and Answer do not match",
			ExceptionCategories.USER_DATA);
	public static final ExceptionCode SECURITY_CODE_MISMATCH = new ExceptionCode("SECURITY_CODE_MISMATCH", "Security Code entered and Security Code on recorde do not match",
			ExceptionCategories.USER_DATA);
	public static final ExceptionCode USERID_LOGINNAME_MANDATORY = new ExceptionCode("USERID_LOGINNAME_MANDATORY",
			"Both UserID and Login are mandatory input fields", ExceptionCategories.USER_DATA);
	public static final ExceptionCode FNAME_LNAME_MANDDATORY = new ExceptionCode("FNAME_LNAME_MANDDATORY", "FirstName and LastName must be provided",
			ExceptionCategories.USER_DATA);
	public static final ExceptionCode UNSUPPORTED_OPERATION = new ExceptionCode("UNSUPPORTED_OPERATION",
			"Unsupported operation please contact customer support", ExceptionCategories.SYSTEM);
	public static final ExceptionCode SECURITY_ANSWER_DOES_NOT_MATCH = new ExceptionCode("SECURITY_ANSWER_DOES_NOT_MATCH",
			"The supplied answer does not match the one on record for this user", ExceptionCategories.USER_DATA);
	public static final ExceptionCode QID_USER_MISMATCH = new ExceptionCode("QID_USER_MISMATCH", "Provided question and user are not associated",
			ExceptionCategories.USER_DATA);
	public static final ExceptionCode NO_CHANGES_FOUND_TO_UPDATE = new ExceptionCode("NO_CHANGES_FOUND_TO_UPDATE", "There were no user profile updates",
			ExceptionCategories.USER_DATA);
	public static final ExceptionCode INSUFFICIENT_REGISTRATION_DATA_EXCEPTION = new ExceptionCode("INSUFFICIENT_REGISTRATION_DATA_EXCEPTION",
			"There is insufficient authorization data for this account. We cannot continue with registration.", ExceptionCategories.USER_DATA);
	public static final ExceptionCode CLEC_ACCOUNT_CANNOT_BE_REGISTERED_UNDER_NON_CLEC_ORG = new ExceptionCode("CLEC_ACCOUNT_CANNOT_BE_REGISTERED_UNDER_NON_CLEC_ORG",
			"The account number entered is a wholesale account and cannot be added to this organization.", ExceptionCategories.USER_DATA);
	public static final ExceptionCode NON_CLEC_ACCOUNT_CANNOT_BE_REGISTERED_UNDER_CLEC_ORG = new ExceptionCode("NON_CLEC_ACCOUNT_CANNOT_BE_REGISTERED_UNDER_CLEC_ORG",
			"The account number entered is not a CLEC account and cannot be added to a CLEC organization.  If you need assistance, please call 800-578-8169 and ask for the billing group.", ExceptionCategories.USER_DATA);
	public static final ExceptionCode INSUFFICIENT_PREVILEGES = new ExceptionCode("INSUFFICIENT_PREVILEGES",
			"You do not have required previleges to process this request", ExceptionCategories.USER_FLOW);

	// Ensemble web service error codes
	public static final ExceptionCode ENS_ERROR = new ExceptionCode("ENS_ERROR", "See error message", ExceptionCategories.SYSTEM);
	public static final ExceptionCode ENS_FAILED = new ExceptionCode("ENS_FAILED", "See error messge", ExceptionCategories.SYSTEM);
	public static final ExceptionCode ENS_ACCOUNT_NUMBER_NOT_FOUND = new ExceptionCode("ENS_ACCOUNT_NUMBER_NOT_FOUND", "The account for the supplied account number was not found", ExceptionCategories.USER_DATA);
	public static final ExceptionCode ENS_INVALID_BAN = new ExceptionCode("INVALID_BAN", "Invalid Billing Account Number", ExceptionCategories.USER_DATA);
	public static final ExceptionCode ENS_PRODUCTS_NOT_FOUND = new ExceptionCode("ENS_PRODUCTS_NOT_FOUND",
			"No Products found", ExceptionCategories.INFORMATIONAL);
	public static final ExceptionCode ENS_INVALID_PARA_GENERIC = new ExceptionCode("INVALID_PARA_GENERIC", "See error messge", ExceptionCategories.USER_DATA);
	public static final ExceptionCode BILL_PARAM_UPDATE_FAILED = new ExceptionCode("BILL_PARAM_UPDATE_FAILED", "Failed to Update. Found more than one billing parameters", ExceptionCategories.USER_DATA);
	public static final ExceptionCode LARGE_CUSTOMER_GENERIC = new ExceptionCode("LARGE_CUSTOMER_GENERIC", "Large customer exception.", ExceptionCategories.USER_DATA);
	public static final ExceptionCode PARA_NOUNBILLED_CALLS = new ExceptionCode("PARA_NOUNBILLED_CALLS", "No unbilled call details.", ExceptionCategories.USER_DATA);
	public static final ExceptionCode PARA_BILLED_CALLS = new ExceptionCode("PARA_BILLED_CALLS", "No billed call details.", ExceptionCategories.USER_DATA);

	public static final ExceptionCode PARA_INVALID_ADDRESS = new ExceptionCode("PARA_INVALID_ADDRESS", "We could not validate the entered Address. Please verify the House Number, Street name Zip are correct.", ExceptionCategories.USER_DATA);
	public static final ExceptionCode BILL_ADDR_VALIDATION_FAILED = new ExceptionCode("BILL_ADDR_VALIDATION_FAILED", "Not able to validate Street Billing address.", ExceptionCategories.USER_DATA);
	public static final ExceptionCode BILL_ADDR_UPDATE_FAILED = new ExceptionCode("BILL_ADDR_UPDATE_FAILED", "Unable to update the Street Billing Address.", ExceptionCategories.USER_DATA);

	// Locator service error codes
	public static final ExceptionCode LOC_NUM_NOT_FOUND = new ExceptionCode("7003", "We could not find the billing telephone number you entered. Please try again.", ExceptionCategories.USER_DATA);

	public static final  String LOGIN_NAME_ALREADY_EXISTS_CODE="LOGIN_NAME_ALREADY_EXISTS";
	public static final String LOGIN_EMAIL_ALREADY_EXISTS_MESSAGE= "The email address you entered cannot be used as your User ID. Please check the email address you entered and make corrections as needed or uncheck the box under the \"Confirm Email Address\" entry fields to create a unique User ID.";
	
	public static final ExceptionCode TOKEN_ALREADY_USED = new ExceptionCode("4004", "The user has already completed the profile using this token. ",ExceptionCategories.USER_DATA);
	public static final ExceptionCode IDM_CURRENTLY_MANAGING = new ExceptionCode("IDM_EXCEPTION_CURRENTLY_MANAGING", "The set currently managing service failed.",ExceptionCategories.SYSTEM);
	
	public static final ExceptionCode NO_ACCOUNT_MATCH = new ExceptionCode("NO_ACCOUNT_MATCH", "NO_ACCOUNT_MATCH", ExceptionCategories.USER_DATA);
	public static final ExceptionCode DVAR_CCV_FAIL = new ExceptionCode("DVAR_CCV_FAIL", "DVAR_CCV_FAIL", ExceptionCategories.SYSTEM);
	
	public static final ExceptionCode CONTEXT_IS_REQUIRED = new ExceptionCode("CONTEXT_IS_REQUIRED", "CONTEXT_IS_REQUIRED", ExceptionCategories.USER_DATA);
	public static final ExceptionCode DVAR_CCV_INSUFFICIENT = new ExceptionCode("7795", "DVAR did not return enough values to process request.", ExceptionCategories.USER_DATA);
	public static final ExceptionCode ALTN_DUPLICATE_ACCT = new ExceptionCode("ALTN_DUPLICATE_ACCT",
			"Sorry - looks like that number is already on your list of alternate contact numbers. Try adding a different number.", ExceptionCategories.USER_DATA);
	public static final ExceptionCode CDS_FAILED = new ExceptionCode("CDS_FAILED",
			"Sorry - We are facing some technical difficulties. Please try again later.", ExceptionCategories.USER_DATA);
	
	public static final ExceptionCode BM_RESOURCE_NOT_FOUND_BAN = new ExceptionCode("BM_RESOURCE_NOT_FOUND_BAN", "BlueMarbel service cann't find the ban in request",
			ExceptionCategories.USER_DATA);
	
	public static final ExceptionCode BM_NO_LIVE_PRODUCT = new ExceptionCode("BM_NO_LIVE_PRODUCT", "BlueMarbel service cann't find live product associated with this ban",
			ExceptionCategories.USER_DATA);
	
	public static final ExceptionCode UNKNOWN_EXCEPTION = new ExceptionCode("UNKNOWN_EXCEPTION", "Unknown Exception", ExceptionCategories.UNKNOWN);
	public static final ExceptionCode UNRESPONSIVE = new ExceptionCode("UNRESPONSIVE", "UNRESPONSIVE", ExceptionCategories.SYSTEM);
	public static final ExceptionCode ASSIA_TOEKN_GET_ERROR = new ExceptionCode("ASSIA100", "Error connecting to ASSIA get token service.", ExceptionCategories.SYSTEM);
	public static final ExceptionCode ASSIA_DEVICE_LIST_ERROR = new ExceptionCode("1049", "Error retreiveing device list from ASSIA.", ExceptionCategories.SYSTEM);
	public static final ExceptionCode ASSIA_STATIONINFO_ERROR = new ExceptionCode("900", "Error retreiveing device list_StationInfo from ASSIA.", ExceptionCategories.SYSTEM);
	public static final ExceptionCode ASSIA_APIINFO_ERROR = new ExceptionCode("901", "Error retreiveing APIInfo from ASSIA.", ExceptionCategories.SYSTEM);
	public static final ExceptionCode ACS_WIFICREDS_MISSING_PARAM = new ExceptionCode("ACS1001", "Missing WIFI Parameters", ExceptionCategories.USER_DATA);
	public static final ExceptionCode MCAFEE_SPECIAL_CHAR = new ExceptionCode("40040","Invalid Characters",ExceptionCategories.USER_DATA);
	public static final ExceptionCode CGS_IDENTIFY_CUSTOMER_FIXED_WIRELESS =  new ExceptionCode(CommonStrings.FIXED_WIRELESS, "This is a fixed wireless moden.", ExceptionCategories.SYSTEM);
	public static final ExceptionCode MCAFEE_INVALID_TOKEN = new ExceptionCode("40101","Invalid Token",ExceptionCategories.USER_DATA);
	public static final ExceptionCode ASSIA_RECOMMENDATION_LIST_ERROR = new ExceptionCode("1049", "Error retreiveing recommendation list from ASSIA.", ExceptionCategories.SYSTEM);
	public static final ExceptionCode ASSIA_THROUGHPUT_LIST_ERROR = new ExceptionCode("1049", "Error retreiveing throughput list from ASSIA.", ExceptionCategories.SYSTEM);
	public static final ExceptionCode ASSIA_TRAFFIC_LIST_ERROR = new ExceptionCode("1049", "Error retreiveing traffic list from ASSIA.", ExceptionCategories.SYSTEM);
	public static final ExceptionCode ASSIA_BROADBAND_US_THROUGHPUT_ERROR = new ExceptionCode("1049", "Error retreiveing broadband US throughput from from ASSIA.", ExceptionCategories.SYSTEM);
	public static final ExceptionCode ASSIA_BROADBAND_DS_THROUGHPUT_ERROR = new ExceptionCode("1049", "Error retreiveing broadband DS throughput from from ASSIA.", ExceptionCategories.SYSTEM);
	public static final String INVALID_USER_DATA_CONDITION_C360 = "INVALID_USER_DATA_CONDITION";
	public static final ExceptionCode INVALID_USER_DATA_CONDITION_EXCEPTION = new ExceptionCode(INVALID_USER_DATA_CONDITION_C360,
			GENERIC_SYSTEM_OUTAGE_MESSAGE);

	public static final ExceptionCode LOGIN_NAME_ALREADY_EXISTS = new ExceptionCode(LOGIN_NAME_ALREADY_EXISTS_CODE, "User with given Login Name already exists",
			ExceptionCategories.USER_DATA);

	public static final ExceptionCode INVALID_USER_DATA_CONDITION = new ExceptionCode(INVALID_USER_DATA_CONDITION_C360, GENERIC_SYSTEM_FUNCTION_MESSAGE,
			ExceptionCategories.SYSTEM);
	public static final String REST_CALL_FAILED = "REST_CALL_FAILED_CODE";
	public static final ExceptionCode REST_CALL_FAILED_EXCEPTION = new ExceptionCode(REST_CALL_FAILED, "REST CALL GETS FAILED");
/*	keep this for now privatee ExceptionCodes() {
		// Don't allow to create ExceptionCodes instance.
	}keep this for now */

	/**
	 * @return the systemExceptionMap
	 */
	private static Map<String, ExceptionCode> getSystemExceptionMap() {

		if (systemExceptionMap == null) {
			systemExceptionMap = new HashMap<>();
			loadSystemMap(systemExceptionMap);
		}
		return systemExceptionMap;
	}

	/**
	 * @return the businessExceptionMap
	 */
	private static Map<String, ExceptionCode> getBusinessExceptionMap() {

		if (businessExceptionMap == null) {
			businessExceptionMap = new HashMap<>();
			loadBusinessMap(businessExceptionMap);
		}
		return businessExceptionMap;
	}

	private static void loadSystemMap(Map<String, ExceptionCode> map) {

		map.put("-1", GENERIC);
		map.put("-1301", DOCS_SYSTEM_EXCEPTION);
		map.put("-1305", EDOCS_EXCEPTION_CD);
		map.put("-1253", EDOCS_EXCEPTION_CD);
		map.put("-1315", IDM_SYSTEM_EXCEPTION_GET_PROFILE);
		map.put("-1318", W3L_SYSTEM_EXCEPTION_CD);
		map.put("-1320", IDM_SYSTEM_EXCEPTION);
		map.put("-1316", IDM_SYSTEM_EXCEPTION_CREATE_PROFILE);
		map.put("-1400", INTEC_TRANSACTION_EXCEPTION);
		map.put("-2000", INVALID_PARAMETER_EXCEPTION);
		map.put("-2012", INVALID_PARAMETER_EXCEPTION);
		map.put("-2013", INVALID_PARAMETER_EXCEPTION);
		map.put("-2040", INVALID_PARAMETER_EXCEPTION);
		map.put("-3521", INVALID_PARAMETER_EXCEPTION);
		map.put("-3550", CTL_CALL_TO_CUST_REGSTRY_FAILD);
		map.put("-3552", CTL_FAILD_TO_CALL_ENSEMBLE);
		map.put("-5012", W3L_REMOTE_EXCEPTION_CD);
		map.put("-5013", W3L_DB_EXCEPTION_CD);
		map.put("-5014", W3L_SYSTEM_EXCEPTION_CD);
		map.put("-3518", W3L_SYSTEM_EXCEPTION_CD);
		map.put("-1346", GENERIC); // Attribute Name already associated to profile
		map.put("-1300", GENERIC); // Unable to connect to the KAL SYstem
		map.put("-9999", GENERIC);
		// CPM
		map.put("666", UNSUPPORTED_OPERATION);
		map.put("0", GENERIC);
		map.put("100", GENERIC);
		
		
		// this errors are from the Ensemble web services. The code is not a numric value but a text value.
		map.put("GENERIC", GENERIC);
		map.put("ERROR", ENS_ERROR);
		map.put("FAILED", ENS_FAILED);
		
		map.put("BILL_ADDR_UPDATE_FAILED", BILL_ADDR_UPDATE_FAILED);
		//msuresh map put("ERROR", IDM_CURRENTLY_MANAGING);
		
	}

	private static void loadBusinessMap(Map<String, ExceptionCode> map) {

		map.put("-1324", USER_LOGIN_ID_NOT_FOUND);
		map.put("-1348", FORGOT_LOGIN_ID_NOT_FOUND);
		map.put("-2108", USER_LOGIN_ID_TAKEN);
		map.put("-2030", INVALID_ACCOUNT_ID_EXCEPTION_CD);
		map.put("-2031", INVALID_ACCOUNT_ID_EXCEPTION_CD);
		map.put("-2035", ACCOUNT_WAS_NOT_FOUND);
		map.put("-2060", INVALID_USER_ID_EXCEPTION);
		map.put("-2092", ACCOUNT_IS_DISCONNECTED);
		map.put("-2093", ACCOUNT_IS_IN_COLLECTIONS);
		map.put("-2094", ACCOUNT_WAS_NOT_FOUND);
		map.put("-2212", ACCOUNT_WAS_NOT_FOUND);
		map.put("-3518", ACCOUNT_WAS_NOT_FOUND);
		map.put("-3517", ACCOUNT_WAS_NOT_FOUND);
		map.put("-2221", ACCOUNT_DISABLED_EXCEPTION_CD);
		map.put("-2506", CUSTOMER_IDM_PROFILE_NOT_FOUND);
		map.put("-2798", MAJOR_BUSINESS_ACCOUNT_EXCEPTION_CD);
		map.put("-3551", CTL_INVALID_BAN);
		map.put("-3553", CTL_BAN_NOT_FOUND_CUSREPO);
		map.put("-5011", INVALID_CUST_CODE_EXCEPTION);
		map.put("-1257", BIZ_REGISTRATION_TOOK_TOO_LONG);
		map.put("-2014", NO_CHANGES_FOUND_TO_UPDATE);

		map.put("-1321", PASSWD_MIN_LENGTH);
		map.put("-1322", PASSWD_MAX_LENGTH);
		map.put("-1323", LOGIN_NAME_INVALID_SPECIAL_CHAR);

		map.put("-300", USER_ID_LOGIN_DOESNT_MATCH);
		map.put("-310", LOGIN_NAME_INVALID_SPECIAL_CHAR);
		map.put("301", PASSWD_MIN_LENGTH);
		map.put("302", PASSWD_MAX_LENGTH);
		map.put("303", PASSWD_REPEATING_CHAR);
		map.put("304", PASSWD_REQUIRED_CHAR);
		map.put("305", PASSWD_ILLEGAL_CHAR);
		map.put("309", PASSWD_RESEMBLANCE_CHAR);
		map.put("310", LOGIN_NAME_INVALID_CHAR);
		map.put("314", PASSWD_ATLEAST_ONE_CHAR);
		map.put("-7", LOGIN_NOT_FOUND);
		map.put("-11", LOGIN_NAME_MAX_LENGTH);
		map.put("-12", LOGIN_NAME_ALREADY_EXISTS);
		map.put("-13", USERID_NOT_FOUND);
		map.put("-16", ACCOUNT_WAS_NOT_FOUND);
		map.put("-19", LOGIN_NAME_ALREADY_EXISTS);
		map.put("-20", INVALID_EMAIL_ID);
		map.put("-24", QID_USER_MISMATCH);
		map.put("-26", LOGIN_NAME_MIN_LENGTH);
		map.put("-27", INVALID_HINT_QUESTION);
		map.put("-28", GROUP_DOESNT_EXIST);
		map.put("-30", GROUP_ALREADY_ASSOCIATED);
		map.put("-31", INVALID_HINT_QUESTION);
		map.put("-151", INVALID_USERID_FORMAT);
		map.put("-152", LOGIN_NAME_INVALID_SPECIAL_CHAR);
		map.put("-153", INVALID_IDENTITY_STATUS);
		map.put("-154", FNAME_LNAME_MANDDATORY);
		map.put("-182", SECURITY_ANSWER_DOES_NOT_MATCH);
		map.put("-184", INVALID_HINT_FORMAT);
		map.put("-185", NEW_PWD_OLD_PWD_SAME);
		map.put("-186", PASSWD_LOGIN_MISMATCH);
		map.put("-187", HINT_QA_MISMATCH);
		map.put("-188", USERID_LOGINNAME_MANDATORY);
		map.put("ALTN_DUPLICATE_ACCT", ALTN_DUPLICATE_ACCT);
		
		// ensemble 
		map.put("ACCOUNT_NUMBER_NOT_FOUND", ENS_ACCOUNT_NUMBER_NOT_FOUND);
		map.put("PARA_INVALID_BAN", ENS_INVALID_BAN);
		map.put("PRODUCTS_NOT_FOUND", ENS_PRODUCTS_NOT_FOUND);
		map.put("ENS_INVALID_PARA_GENERIC", ENS_INVALID_PARA_GENERIC);
		map.put("BILL_PARAM_UPDATE_FAILED", BILL_PARAM_UPDATE_FAILED);
		map.put("INSUFFICIENT_PREVILEGES", INSUFFICIENT_PREVILEGES);
		map.put("LARGE_CUSTOMER_GENERIC", LARGE_CUSTOMER_GENERIC);
		map.put("PARA_NOUNBILLED_CALLS", PARA_NOUNBILLED_CALLS);
		map.put("PARA_BILLED_CALLS", PARA_BILLED_CALLS);
		map.put("BILL_ADDR_VALIDATION_FAILED", BILL_ADDR_VALIDATION_FAILED);
		map.put("PARA_INVALID_ADDRESS", PARA_INVALID_ADDRESS);
		map.put("7003", LOC_NUM_NOT_FOUND);
		map.put("4004", TOKEN_ALREADY_USED);
		map.put(CommonStrings.FIXED_WIRELESS, CGS_IDENTIFY_CUSTOMER_FIXED_WIRELESS);
}

	/**
	 * This is a special helper message to return ExceptionCode objects that map to some int based
	 * error code. Some systems use int based error code so this method can be used to convert them
	 * to the ExceptionCode we want. Of course the code would first have to have been added to the
	 * code in the loadMap method GENERIC is the catch all for not founds or failures
	 * 
	 * @return the ExceptionCode
	 */
	public static ExceptionCode getExceptionForNumber(int number, boolean returnNull) {
		ExceptionCode rtrnCode = GENERIC;
		ExceptionCode work = null;
		try {
			String key = String.valueOf(number);
			work = getSystemExceptionMap().get(key);
			if (work != null) {
				rtrnCode = work;
			} else {
				work = getBusinessExceptionMap().get(key);
				if (work != null) {
					rtrnCode = work;
				}
			}
		} catch (Exception ex) {
			// If you want some kind of tracking for when this happens add hear
			// But I'm gonna ignore this
		}
		if (work == null && returnNull) {
			return null;
		}
		return rtrnCode;
	}

	/**
	 * This is a special helper message to return ExceptionCode objects for ensemble web services that map to some int based
	 * error code. Some systems use int based error code so this method can be used to convert them
	 * to the ExceptionCode we want. Of course the code would first have to have been added to the
	 * code in the loadMap method GENERIC is the catch all for not founds or failures
	 * 
	 * @return the ExceptionCode
	 */
	public static ExceptionCode getExceptionForNumber(String key, boolean returnNull) {
		ExceptionCode rtrnCode = GENERIC;
		ExceptionCode work = null;
		try {
			work = getSystemExceptionMap().get(key);
			if (work != null) {
				rtrnCode = work;
			} else {
				work = getBusinessExceptionMap().get(key);
				if (work != null) {
					rtrnCode = work;
				}
			}
		} catch (Exception ex) {
			// If you want some kind of tracking for when this happens add hear
			// But I'm gonna ignore this
		}

		if (work == null && returnNull) {
			rtrnCode = null;
		}
		
		return rtrnCode;
	}
	
	/**
	 * This is a special helper message to decide if an int code should be considered a Business
	 * Exception or a System Exception. While this is not one hundred pct accurate (numbering has
	 * not always been consistently used) it is reasonably close. Most system exceptions fall
	 * between -1000 and -2000 Note that this does not work for IDM/CPM direct calls as they use a
	 * different error numbering system Modify this method as need be to include special cases.
	 * Default value will be true
	 * 
	 * @return boolean
	 */
	public static boolean isSystemExceptionCode(int number) {
		boolean rtrnVal = true;
		try {
			String key = String.valueOf(number);
			ExceptionCode work = getSystemExceptionMap().get(key);
			rtrnVal = work != null;

		} catch (Exception ex) {
			// If you want some kind of tracking for when this happens add hear
			// But I'm gonna ignore this
		}
		return rtrnVal;
	}

	
	// use this method for Ensemble web services
	public static boolean isSystemExceptionCode(String key) {
		boolean rtrnVal = true;
		try {
			ExceptionCode work = getSystemExceptionMap().get(key);
			rtrnVal = work != null;

		} catch (Exception ex) {
			// If you want some kind of tracking for when this happens add hear
			// But I'm gonna ignore this too
		}
		return rtrnVal;
	}

	public static boolean isBusinessExceptionCode(int number) {
		boolean rtrnVal = true;
		try {
			String key = String.valueOf(number);
			ExceptionCode work = getBusinessExceptionMap().get(key);
			rtrnVal = work != null;

		} catch (Exception ex) {
			// If you want some kind of tracking for when this happens add hear
			// But I'm gonna ignore this
		}
		return rtrnVal;
	}

	
	// use this method for Ensemble web services
	public static boolean isBusinessExceptionCode(String key) {
		boolean rtrnVal = true;
		try {
			ExceptionCode work = getBusinessExceptionMap().get(key);
			rtrnVal = work != null;

		} catch (Exception ex) {
			// If you want some kind of tracking for when this happens add hear
			// But I'm gonna ignore this too
		}
		return rtrnVal;
	}

}
