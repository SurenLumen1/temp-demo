package com.lumen.dssh.orchestrator.common;

public class CommonStrings {
    CommonStrings() {
    }

    // PUSH comment
    public static final String REMOTE_USER_NOT_POPULATED = "Remote user not populated";
    public static final String CT_REMOTE_USER = "IFIXXEDMyMTV";
    public static final String APP_KEY = "OscarTheGrouch";
    public static final String CONNECTED_VOICE_ELIGIBILITY = "CONNECTED_VOICE";
    public static final String CONNECTED_VOICE_ADD = "CONNECTED_VOICE_ADD";
    public static final String POST_LOGIN_REDIRECT_URI_SESSION_ATTR = "POST_LOGIN_REDIRECT_URI_SESSION_ATTR";

    public static final String CUST_MYA_DATASTAX_SESSION_COOKIE = "CUST_MYA_DATASTAX_SESSION_COOKIE";

    public static final String CUST_MYA_COUCHBASE_SESSION_ATTR = "CUST_MYA_COUCHBASE_SESSION_ATTR";
    public static final String CUST_MYA_COUCHBASE_SESSION_ATTR_ACCOUNT_NUMBER = "CUST_MYA_COUCHBASE_SESSION_ATTR_ACCOUNT_NUMBER";
    public static final String CUST_MYA_DATASTAX_SESSION_ATTR = "CUST_MYA_DATASTAX_SESSION_ATTR";
    public static final String ECOM_USER_PROFILE = "/digihome/profile/getRegisteredEcomUser";
    public static final String CUST_MYA_LOGGER_COOKIE = "CUST_MYA_LOGGER_COOKIE";
    public static final String UPDATE_ACCOUNT_NOTES ="/digihome/ppp/updateAccountNotes";
    public static final String CONSMOBILE_SESSION_ATTRIBUTES = "CONSMOBILE_SESSION_ATTRIBUTES";

    public static final String CUSTCARE_OAUTH2_AUTH_BACKUP_SESSION_ATTR = "CUSTCARE_OAUTH2_AUTH_BACKUP_SESSION_ATTR";

    public static final String X_CTL_CONSUMER_USERNAME = "myLittlePony";

    public static final String GET_ECOM_USER_PROFILE = "/getEcomUserProfile";

    public static final String DEVICE_REBOOT = "/deviceReboot";

    public static final String GET_HOSTS = "/getHosts";

    public static final String GET_CONNECTION_STATUS ="/getConnectionStatus";

    public static final String GET_DEVICE_LIST = "/dss/assia/deviceList";

    public static final String GET_ASSIA_URL = "/dss/assia";

    public static final String GET_REQUEST_ID= "/getAssiaRequestID";
    public static final String GET_SMART_NID_INFO = "/dss/acs/getModemDetailsSmartNID";

    public static final String GET_ENDPOINTS_BY_QUERY = "/dss/acs/getEndpointsByQuery";

    public static final String GET_NETWORK_DETAILS_PLUME = "/dss/plume/networkDetailsPlume";
    public static final String RELEASE_WALLED_GARDEN_URI="/dss/improv/releaseFromWalledGarden";
    public static final String CAPTIVE_PORTAL_RELEASE_URI="/dss/acs/releaseCaptivePortal";
    public static final String SELF_INSTALL_INVENTORY_UPDATE="/dss/acs/selfInstallInventoryUpdate";
    public static final String SELF_INSTALL_GET_IP_ADDRESS="/dss/acs/getIPAddress";
    public static final String SELF_INSTALL_VERIFY_WALLED_GARDEN="/dss/ros/verifyWalledGarden";
    public static final String GET_AP_INFO = "/dss/assia/apInfo";
    public static final String SERIAL_NUMBER_PARAMETER = "?serialNumber=";

    public static final String ASSIA_HISTORICAL_SPEED = "/dss/assia/historicalSpeeds";

    public static final String ASSIA_CURRENT_SPEED = "/dss/assia/realtimeSpeeds";
    public static final String REQUEST_ID_REALTIMESPEED_PARAMETER = "&requestID=";

    public static final String GET_WIRELESS_INFO = "/getWirelessInfo";

    public static final String GET_INVOICE_HISTORY_INFO = "/getInvoiceHistoryInfo";

    public static final String GET_TAX_AND_DISCOUNTS = "/getTaxAndSpecialDiscountBreakupByTransaction";

    public static final String UPDATE_CREDENTIALS = "/updateCredentials";

    public static final String RESET_CREDENTIALS = "/resetCredentials";

    public static final String SET_CURRENT_ACCOUNT = "/setcurrent";

    public static final String DSS_ACCOUNT_PATH = "/digihome/account";

    public static final String DSS_PROFILE_PATH = "/digihome/profile";

    public static final String UPDATE_PAPERLES_BILLING = "/ensupdatepaperless";
    public static final String CRIS_UPDATE_PAPERLESS_BILLING = "/digihome/dvar/updatePaperlessBilling";

    public static final String GET_TAX_AND_RATE_SERVICE = "/digihome/account-orders-services/getTaxAndRatesService";
    public static final String DSS_PAYMENT_BILLING_PATH = "/digihome/payment-billing-services";
    public static final String DSS_PAYMENT_BILLING_DUE = "/dss/cips/pa/getPaymentArrangementsDetails";
    public static final String DSS_PAYMENT_AUTHORIZE_PAYMENT = "/dss/epwf/authorizePayment";

    public static final String GET_CUSTOMER_PAYMENT_INFO = "/getCustomerPaymentInfo";

    public static final String GET_USER_PROFILE = "/digihome/profile/getUserProfile";

    public static final String GET_ACCOUNT = "/digihome/dvar/getAccount";

    public static final String MY_SERVICES_DIO_SAO = "/digihome/account/myServices";

    public static final String MY_SERVICES_BM = "/digihome/account/myServicesBM";

    public static final String GET_C360_CI = "/digihome/account/getC360CustomerIdentificationData";

    public static final String GET_OUTAGE_DETAILS = "/dss/api/outage/getOutageInfo";


    public static final String GET_OUTAGE_NOTIFICATION = "/dss/api/outage/getHsiOutageNotificationDetails";
    public static final String GET_TRACKING_INFO = "/dss/api/straviso/getTrackingInfo";

    public static final String UPDATE_OUTAGE_NOTIFICATION = "/dss/api/outage/updateOutageNotificationInfo";

    public static final String GET_USERS = "/digihome/profile/getUsers";


    public static final String JUMP_IN = "/digihome/ecommsvc/jumpIn";

    public static final String JUMP_OUT = "/digihome/ecommsvc/jumpOut";
    public static final String CHECK_PAPERLESS_BILLING_BY_BAN = "/digihome/eds/checkpaperlessbillingbyban";

    public static final String SHELL_REMINDER = "/digihome/profile/sendShellReminder";
    public static final String SHELL_REMINDER_TOKEN = "/digihome/profile/sendShellReminderWithToken";
    public static final String UPDATE_SHELL_PROFILE = "/digihome/profile/updateShellProfile";
    public static final String PPP_GET_ACCOUNT_DETAILS = "/digihome/ppp/getAccountDetails";
    public static final String PPP_GET_WG_STATUS = "/digihome/ppp/getWGStatus?baid=";
    public static final String RATE_INCREASE="/digihome/bmOrderMgmt/getRateIncreaseData";
    public static final String SHELL_IDENTITY_STATUS = "2";
    public static final String ORDER_NUMBER = "OrderNumber";

    public static final String PPP_STAGE_WG_PAYMENT = "/digihome/ppp/stageWGPayment";

    public static final String ACATOO_PROFILE = "Provisional Profile Indicator";

    public static final String GET_SHIPMENT_INFO = "/dss/api/getShipmentsInfo?accountNumber=";

    public static final String COMPANY_OWNER_ID = "MarkJSturmer";
    public static final String COMPANY_OWNER_CENTURYLINK = "1";
    public static final String COMPANY_OWNER_BRIGHTSPEED = "4";

    public static final String CURRENTLY_MANAGING = "CurrentlyManaging";

    public static final String GET_C360_ORDER_PREPAID_USER = "/digihome/account/getPrepaidAcatooOrderDetails";

    public static final String GET_C360_ORDER_POSTPAID_USER = "/digihome/account/getPostpaidAcatooOrderDetails";

    public static final String GET_C360_PENDING_ORDERS = "/digihome/account/getC360PendingOrderRes";

    public static final String GET_EMAIL_ADDRESS = "/verifyEmailAddress";

    public static final String GET_C360_MODEM_DATA = "/digihome/account/getC360ModemData";

    public static final String C360_MODEM_DATA = "/digihome/account/c360ModemData";

    public static final String GET_CIPS_PAYMENT_RESPONSE = "/dss/cips/getCustomerPaymentInfo";

    public static final String GET_BILL_PDF_RESPONSE = "/dss/clou/billingInvoice/getBillPDF";

    public static final String BILLING_APPLICATION_CD = "ENS";

    public static final String REQUEST_PARAM_TYPE = "BillingAccountNumber";

    public static final String INPUT_CHANNEL_CODE = "MYA_PAY";

    public static final String SRC_APPLICATION_CD = "MYACCOUNT";

    public static final String NLAD_ENROLL = "/nlad/enroll";

    public static final String NLAD_VERIFY = "/nlad/verify";

    public static final String DOCS_INTAKE = "/ebbpintakedocs";

    public static final String GET_SF_CASE = "/getSfCase";

    public static final String POST_EVENTS = "/events";

    public static final String BILLING_SRC = "myaAcct";

    public static final String NLAD_APPLICATION_STATUS_APPROVED = "Approved";

    public static final String NLAD_APPLICATION_STATUS_NOT_APPROVED = "Not Approved";

    public static final String EAT_SERVICE_FAIL = "EAT Token failure";

    public static final String SAC_SERVICE_FAIL = "SAC Code failure";

    public static final String EAT = "EAT";

    public static final String SAC = "SAC";

    public static final String SF_CASE = "Salesforce Case";

    public static final String ENROLL_NLAD = "NLAD enroll";

    public static final String SYS_EXCPTN_TRY_LTR = "SYS_EXCPTN_TRY_LTR";

    public static final String GET_SAC = "/getSAC/";

    public static final String GET_EAT = "/eatToken";
    public static final String SUCCESS = "success";
    public static final String FAILURE = "failure";
    public static final String CHANGE_LOGIN = "/digihome/profile/changeLogin";
    public static final String USERID_LENGTH_ERROR = "USERID_LENGTH_ERROR";
    public static final String USERID_INVALID_ERROR = "USERID_INVALID_ERROR";
    public static final String ERROR_NULLPOINTER = "ERROR_NULLPOINTER";
    public static final String USERID_LENGTH_ERROR_MSG = "User id must consists of at least six characters and at most 254 characters";
    public static final String USERID_INVALID_ERROR_MSG = "Please enter a valid User ID";
    public static final String ERROR_NULLPOINTER_MSG = "form data not received";

    public static final String CHANGE_PASSWORD_RESOURCE = "/digihome/profile/changePassword";
    public static final String GET_IDENTITIES_FOR_EMAIL_RESOURCE = "/digihome/profile/getIdentitiesForEmail";
    public static final String GET_IDENTITY_RESOURCE = "/digihome/profile/getIdentity";
    public static final String GET_ACCOUNTS_FOR_LOGIN_RESOURCE = "/digihome/profile/getAccountsForLogin";
    public static final String VALIDATE_TOKEN_RESOURCE = "/digihome/ecommsvc/validateToken";
    public static final String SEND_AUTH_CODE_RESOURCE = "/digihome/profile/sendAuthCode";

    public static final String RESPONSE = "response";
    public static final String REJECTED = "REJECTED";
    public static final String COMMENTS = " :COMMENTS=";
    public static final String DUPLICATE_SUBSCRIBER = "DUPLICATE_SUBSCRIBER";
    public static final String DUPLICATE_TELEPHONE = "DUPLICATE_TELEPHONE";
    public static final String INCOMPLETE = "INCOMPLETE";
    public static final String INVALID_VALUE = "INVALID_VALUE";
    public static final String MALFORMED = "MALFORMED";
    public static final String NOT_FOUND = "NOT_FOUND";
    public static final String PENDING = "PENDING";
    public static final String UPDATE_IDENTITY = "/updateIdentity";
    public static final int NOT_FOUND_IDX = -1;
    public static final String DBL_DASH = "--";
    public static final String DBL_PERIOD = "..";
    public static final String DBL_UNDERSCORE = "__";
    public static final String DBL_PLUS = "++";
    public static final String EMAIL_REQUIRED = "EMAIL_REQUIRED";
    public static final String EMAIL_INVALID = "EMAIL_INVALID";
    public static final String EMAIL_INVALID_MSG = "Please enter a valid Email ID";
    public static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String GET_DVAR_NOTIF_PREFS = "/digihome/dvarnotif/getDvarNotifPrefs?accountNumber=";
    public static final String NOTIFICATION_EMAIL_REQUIRED = "NOTIFICATION_EMAIL_REQUIRED";
    public static final String NOTIFICATION_SMS_REQUIRED = "NOTIFICATION_SMS_REQUIRED";
    public static final String NOTIFICATION_PAYMENT_REMINDER_REQUIRED = "NOTIFICATION_PAYMENT_REMINDER_REQUIRED";
    public static final String NOTIFICATION_PAYMENT_BILL_EXCEEDS_AMOUNT_REQUIRED = "NOTIFICATION_PAYMENT_BILL_EXCEEDS_AMOUNT_REQUIRED";
    public static final String DVAR_NOTIF = "/digihome/dvarnotif";
    public static final String UPDATE_POSTPAID_NOTIF = "/updDvarNotifPrefs";
    public static final String UPDATE_ACCOUNT_EMAIL = "/digihome/dvarAccount/updateDvarAccountEmail";

    public static final String UPDATE_ALTERNATE_TN = "/digihome/cds/updateAltTn";
    public static final String GET_ACCOUNT_INFO_BY_ACCOUNT_NUMBER = "/digihome/cds/getByAccountNumber?accountNumber=";
    public static final String RETRIEVE_ACCOUNTS_FROM_EMAIL = "/digihome/cds/getDataByEmail?email=";

    public static final String WIFI_SUCCESS_MSG = "Success";
    public static final String WIFI_FAILURE_MSG = "Failure";
    public static final String WIFI_ERROR_MSG_GENERAL = "Error parsing response from service";
    public static final String WIFI_ERROR_MSG_NO_24 = "No enabled modems found";
    public static final String WIFI_SUCCESS_STATUS = "0";
    public static final String WIFI_FAILURE_STATUS = "1";

    public static final String WIFI_24 = "2.4GHz";
    public static final String WIFI_5 = "5GHz";
    public static final String WIFI_RADIO_FREQUENCY = "RadioFrequency";
    public static final String WIFI_SSID = "SSID";
    public static final String WIFI_SSID_NAME = "myLittlePony";
    public static final String WIFI_WIRELESS_KEY = "Grover";
    public static final String WIFI_ENCRYPTION_TYPE = "ThatsForMe2KnowAndYou2FindOut";
    public static final String WIFI_ENABLED = "Enable";
    public static final String WIFI_WIRELESS_KEY_STRENGTH = "WirelessKeyStrength";
    public static final String WIFI_SSID_ADVERTISED = "SSIDAdvertised";
    public static final String WIFI_MAC_ADDRESS_CONTROL_ENABLED= "MACAddressControlEnabled";
    public static final String WIFI_WIRELESS_STANDARD= "WirelessStandard";
    public static final String WIFI_POSSIBLE_CHANNELS= "PossibleChannels";
    public static final String WIFI_CHANNEL= "Channel";
    public static final String WIFI_ENABLE_POSSIBLE= "EnablePossible";
    public static final String WIFI_TRANSMIT_POWER_SUPPORTED= "TransmitPowerSupported";
    public static final String WIFI_TRANSMIT_POWER= "TransmitPower";
    public static final String WIFI_AUTO_CHANNEL_ENABLED= "AutoChannelEnabled";
    public static final String WIFI_WPS_CAPABLE= "WPSCapable";
    public static final String WIFI_WPS_ENABLED= "WPSEnabled";
    public static final String WIFI_ENABLED_VALUE = "1";
    public static final String UPDATE_MAILING_ADDRESS = "/digihome/dvar/updateAddress";
    public static final String BILLER_ENSEMBLE = "ENSEMBLE";
    public static final String BILLER_CRIS = "CRIS";
    public static final String PRODUCT_POTS = "POTS";
    public static final String PRODUCT_WIRELINE_I = "WIRELINE-I";
    public static final String PRODUCT_BROADBAND = "BROADBAND";
    public static final String UNAUTHORIZED_ACCOUNT = "UNAUTHORIZED_ACCOUNT";

    public static final String ACS_BASE_URI = "/dss/acs";
    public static final String DEFAULT_BASE_NETWORK_SERVCIES_URL = "http://dssh-e2e.test.intranet";


    public static final String PAYMENT_BILLING_SERVICES_BASE_URI = "/digihome/payment-billing-services";

    public static final String ADD_ALT_TN = "/digihome/cds/addAltTn";

    public static final String UPDATE_PREPAID_NOTIFICATION = "/digihome/cds/updatingNotificationPreference";
    public static final String UPDATE_PREPAID_ACCOUNT_EMAIL = "/digihome/cds/updatePrepaidAccountEmail";
    public static final String DVAR_ACCOUNT_NOT_FOUND_EXCEPTION = "DVAR-0001/FOUND_NO_ACCOUNT";
    public static final String ARCHIVED = "ARCHIVED";


    public static final String AOS_SUCCESS_MSG = "SUCCESS";
    public static final String AOS_FAILURE_MSG = "FAILURE";
    public static final String AOS_BAID = "BAID";
    public static final String AOS_ALL = "ALL";
    public static final String AOS_CONFIRMATION_ID_WITH_PAYMENT = "CONFIRMATIONIDWITHPAYMENT";
    public static final String AOS_SEARCH_CRITERIA = "searchCriteria";
    public static final String AOS_SEARCH_CRITERIA_VALUE = "searchCriteriaValue";
    public static final String AOS_INVOICE_SEARCH_CRITERIA = "invoiceSearchCriteria";
    public static final String AOS_NEXT_PAYMENT = "NextPayment";
    public static final String AOS_SRC_SYSTEM = "MYACCOUNT";
    public static final String AOS_PPP_BASE_URI = "/digihome/ppp";

    public static final String DELETE_ALT_TN = "/digihome/cds/deleteAltTn";
    public static final String DECLINE_ALTERNATE_TN = "/digihome/cds/declineAltTn";

    public static final String DIGIHOME_UPDATE_ATTR = "/digihome/profile/addAccountAttribute";

    public static final String MCAFEE_SKU_5_DEVICES = "1498-128743-mma5dshp";

    public static final String MCAFEE_SKU_10_DEVICES = "1498-120101-mmasdk10d";
    public static final String QUERY_LICENSE = "/dss/mcafee/queryLicense";
    public static final String TEMPLATES_PATH = "src/main/resources";

    public static final String MCAFEE_PROVISION_CUSTOMER = "/dss/mcafee/provisionCustomer";
    public static final String MCAFEE_GET_TOKEN = "/dss/mcafee/token";
    public static final String MCAFEE_GET_ALL_DEVICES = "/dss/mcafee/getAllMcAfeeDevices";

    public static final String GET_ALL_DEVICE_ASSIGNMENTS_FOR_MODEM = "/dss/mcafee/getAllDeviceAssignmentsForModem";
    public static final String RETRIEVE_PROFILELIST = "/dss/mcafee/retrieveProfileList";
    public static final String RETRIEVE_PROFILE_DEVICE_LIST = "/dss/mcafee/retrieveProfileDeviceList";
    public static final String ADD_REMOVE_DEVICES ="/dss/mcafee/addRemoveDevices";

    public static final String MCAFEE_GET_MAC_DEVICE_LIST = "/dss/mcafee/getMacDeviceList";

    public static final String MCAFEE_GET_INTERNET_ACCESS_STATUS_OF_ALL_PROFILE = "/dss/mcafee/getInternetAccessStatusOfAllProfile";

    public static final String MCAFEE_GET_INTERNET_ACCESS_STATUS_OF__PROFILE = "/dss/mcafee/getInternetAccessStatusOfProfile";
    public static final String MCAFEE_SET_INTERNET_ACCESS_STATUS_OF__PROFILE = "/dss/mcafee/setInternetAccessForProfile";

    public static final String MCAFEE_GET_INTERNET_ACCESS_STATUS_OF_PROFILE = "/dss/mcafee/getInternetAccessStatusOfProfile";

    public static final String MCAFEE_GET_INTERNET_ACCESS_STATUS_OF_DEVICE = "/dss/mcafee/getInternetAccessStatusOfDevice";
    public static final String MCAFEE_UPDATE_PROFILE = "/dss/mcafee/updateMcafeeProfile";
    public static final String MCAFEE_UPDATE_CATEGORY_LIST_OF_PROFILE = "/dss/mcafee/updateCategoryListOfProfile";
    public static final String MCAFEE_SET_INTERNET_ACCESS_FOR_ALL_PROFILE = "/dss/mcafee/setInternetAccessForAllProfile";
    public static final String MCAFEE_SET_INTERNET_ACCESS_FOR_DEVICE = "/dss/mcafee/setInternetAccessForDevice";
    public static final String MCAFEE_ADD_PROFILE = "/dss/mcafee/addProfile";

    public static final String MCAFEE_UPDATE_DEVICE = "/dss/mcafee/updateDevice";
    public static final String MCAFEE_CATEGORY_LIST_OF_PROFILE = "/dss/mcafee/updateCategoryListOfProfile";
    public static final String MCAFEE_GET_CATEGORIES_LIST_FOR_PROFILE = "/dss/mcafee/getCategoriesListForProfile";

    public static final String MCAFEE_CREATE_MEMBER_TIME_POLICY = "/dss/mcafee/createMemberTimePolicy";
    public static final String MCAFEE_DELETE_PROFILE = "/dss/mcafee/deleteProfile";
    public static final String MCAFEE_DELETE_MEMBER_TIME_POLICY = "/dss/mcafee/deleteMemberTimePolicy";
    public static final String MCAFEE_UPDATE_MEMBER_TIME_POLICY = "/dss/mcafee/updateMemberTimePolicy";
    public static final String MCAFEE_PROVISION_SUCCESS_CODE = "1000";
    public static final String MCAFEE_PROVISION_DUPLICATE_CODE_1 = "5001";
    public static final String MCAFEE_PROVISION_DUPLICATE_CODE_2 = "5002";

    public static final String MCAFEE_DOWNLOAD_ERROR = "MCAFEE_DOWNLOAD_ERROR";

    public static final String CLASSPATH = "classpath:";

    public static final String SUCCESS_STATUS = "1";
    public static final String WALLETID = "walletId";

    public static final String FAILURE_STATUS = "0";

    public static final String ACC_NUM = "/dss/clou/billingInvoice/getBillDates?acctNo=";
    public static final String BTNCC_NUM = "&btncc=";
    public static final String GET_BILLING_DETAILS_BY_BAN = "/digihome/ens/customer/getBillingDetails?ban=";

    public static final String GET_PDF_SUCCESS_STATUS = "0";
    public static final String GET_PDF_FAILURE_STATUS = "0";


    //Enrollment flow constants
    public static final String IS_ACCOUNT_REGISTRABLE_RESOURCE = "/digihome/ecommsvc/registration/";
    public static final String UNKNOWN = "unknown";
    public static final String WHOLESALE_TYPE_CLEC = "CLEC";
    public static final String IAR_AUTH_CODE = "Snuffleupigus";
    public static final String CLEC_ATTRIBUTE = "CLEC_ACCOUNT";
    public static final String BUSINESS = "Business";
    public static final String INVOICE_PRINT_OPTION_PAPERLESS_BILLING = "1";
    public static final String RESIDENCE = "Residential";
    public static final String WHOLESALE_GROUP = "WHOLESALE";
    public static final String ENSEMBLE_BUSINESS_GROUP = "ENSEMBLE.B";
    public static final String CRIS_BUSINESS_GROUP = "CRIS.OTHER";
    public static final String INVOICE_PRINT_OPTION_PAPER_BILLING = "0";
    public static final String CLEC = "CLEC";
    public static final String WHOCUST = "WHOCUST";

    public static final String ADD_ACCOUNT_TO_USER = "/digihome/ecommsvc/addAccountToUser";
    public static final String GET_BILLED_CALL_DETAILS = "/digihome/ens/customer/getBilledCallDetail";
    public static final String PARA_BILLED_CALLS = "PARA_BILLED_CALLS";
    public static final String CREATE_PROFILE = "/digihome/profile/createProfile";
    public static final String SUCCESS_CHAR = "S";

    public static final String CHANGE_PASSWORD_WITH_TOKEN = "/digihome/profile/changePasswordWithToken";
    public static final String GET_PROFILE_BY_ORDER_NUM = "/digihome/profile/getProfilebyOrdNumber/";

    public static final String CREATE_ACOD_PROFILE = "/digihome/profile/createTheShellUser";
    public static final String SEND_TEMP_PE_RESOURCE = "/digihome/ecommsvc/sendTemporaryPassword";
    public static final String NTFWF_SEND_USERID = "/dss/forgot/sendUsernames";
    public static final String NTFWF_SEND_ACCOUNTS = "/dss/forgot/sendAccounts";

    public static final String AUTHORIZATION = "notEncrypted";
    public static final String TO_PAGE_PARAMETER = "&toPage=";
    public static final String SOURCE_PARAMETER = "&source=";
    public static final String TOKEN_PARAMETER = "?token=";
    public static final String JUMP_OUT_TO_DIGITAL_HAWK_URI = "/customer/login?encryptedusername=";
    public static final String JUMP_OUT_TO_DIGITAL_HAWK_MOVERS_URI = "/customer/login?flow=move&encryptedusername=";
    public static final String JUMP_OUT_TO_DIGITAL_HAWK_CHANGE_MODEM_URI = "/customer/login?flow=changeModem&encryptedusername=";
    public static final String JUMP_OUT_TO_HSI_NOTIFY_ME_URI = "/MasterWebPortal/freeRange/centurylink/ctlPrismHSINotifyDataUpdate_loadMANotifyMePage";
    public static final String JUMP_OUT_TO_DIGITAL_HAWK_PERSONAL_TECH_PRO_URI = "/ec/login?flow=VAS&encryptedusername=";
    public static final String JUMP_OUT_TO_DIGITAL_HAWK_CYBER_SHIELD_URI = "/ec/login?flow=VAS&encryptedusername=";
    public static final String JUMP_OUT_TO_DECO_CHANGE_DUE_DATE_URI = "/ec/login?flow=changeDueDate&encryptedusername=";
    public static final String JUMP_OUT_TO_DIO_CONNECTED_VOICE_URI = "/ecmanage/login?flow=connectedVoice&encryptedusername=";
    public static final String JUMP_OUT_TO_DIO_CONNECTED_VOICE_CANCEL_URI = "/ecmanage/login?flow=cvcancel&encryptedusername=";
    public static final String JUMP_OUT_TO_VACATION_URI = "/ecmanage/login?flow=vacation&encryptedusername=";
    public static final String JUMP_OUT_TO_VACATION_SUSPEND_URI = "/ecmanage/login?flow=vacationSuspend&encryptedusername=";
    public static final String JUMP_OUT_TO_VACATION_RESTORE_URI = "/ecmanage/login?flow=vacationRestore&encryptedusername=";
    public static final String JUMP_OUT_TO_DECO_VAS = "/ec/login?flow=VAS&encryptedusername=";
    public static final String JUMP_OUT_TO_DSSR_TICKETING_URI = "/digicustcare/stsPostLogin";
    public static final String JUMP_OUT_TO_DSSR_TECH_TRACKER_URI= "/digicustcare/techLocation?trackerInfo=";
    public static final String JUMP_OUT_TO_DSSP_MANAGE_WALLET = "/wallet/manage";
    public static final String JUMP_OUT_DSSP_PAY_BILL_URI = "/postbill/payment/view";
    public static final String JUMP_OUT_TO_DSSP_AUTO_PAY_URI = "/autopay/manage";
    public static final String JUMP_OUT_TO_DSSP_BILL_DISPUTE_URI = "/billdispute/reviewbill";
    public static final String JUMP_OUT_TO_PAYMENT_PLAN_URI="/pa/postPAIdentify";

    public static final String STRIP_CHARS = "%&|&;$%@<>()+,/\n\r\\\'\"";
    public static final String REPLACE_CHARS = "                    ";
    public static final String CANCEL_SERVICE = "/digihome/account/cancelService";
    public static final String MONTH_YEAR_FORMAT = "MM/yyyy";
    public static final String VANITY = "vanity.";
    public static final String DOT_COM_HOST = "dotcomHost";
    public static final String SHOP = "shop";
    public static final String UTF8 = "UTF-8";

    public static final String INACTIVE = "INACTIVE";
    public static final String ACTIVE = "ACTIVE";
    public static final String PPP_DIGITAL_PHONE_PRODUCT = "BVOIP Service";
    public static final String PPP_STATIC_IP_PRODUCT = "Static IP Service";
    public static final String PPP_SMALL_BUSINESS_ACCOUNT = "CXSB";
    public static final String PPP_CTL_ON_ACCOUNT = "ON";
    public static final String WALLET_REF_NO = "walletRefNo";
    public static final String ENS_WIRE_LINE_C_TYPE = "WIRELINE-C";

    public static final String BRSPD_OWNED = "BRSPD_OWNED";
    public static final String IS_OWNED = "isOwned";
    public static final String CONNECTED_VOICE = "CONNECTED_VOICE";
    public static final String PERSONAL_TECH_PRO = "PERSONAL_TECH_PRO";
    public static final String CYBER_SHIELD = "CYBER_SHIELD";
    public static final String SOURCE_SYSTEM_DIO = "DIO";
    public static final String SOURCE_SYSTEM_BM = "BM";
    public static final String SIMPLY_UNLIMITED_PHONE = "SIMPLY_UNLIMITED_PHONE";
    public static final String VACATION_SERVICE_START = "VACATION_SERVICE_START";
    public static final String VACATION_SERVICE_END = "VACATION_SERVICE_END";
    public static final String M2W_URI = "/digihome/m2w/getM2WListOfEmails";
    public static final String M2W_ACC_DETAILS = "/digihome/m2w/getEmailAccountsFromBM";
    public static final String EC_ORDERING_OFFERS_URI = "/ecOrdering/offers";
    public static final String EC_ORDERING_ADDON_OFFERS_URI = "/ecOrdering/addOnOffers";
    public static final String EC_ORDERING_APPOINTMENTS_URI = "/ecOrdering/appointments";
    public static final String EC_ORDERING_TAXES_URI = "/ecOrdering/taxes";
    public static final String EC_ORDERING_SUBMIT_ORDER_URI = "/ecOrdering/submitOrder";
    public static final String EC_PROD_SRVCS_URI = "/ecOrdering/retrieveProductsAndServices";
    public static final int CONPORT_REDIRECT_STATUS = 222;
    public static final int NO_ACCOUNTS_ASSOCIATED_ERROR = 223;
    public static final String NOT_AVAILABLE = "NA";
    public static final String ACCOUNT_TYPE_PPB = "PPB";
    public static final String ACCOUNT_TYPE_BAN = "BAN";
    public static final String PENDING_ORDER_CANCEL = "PENDING_ORDER_CANCEL";
    public static final String PROFILE_ID = "profileId";
    public static final String ACCOUNT_NUMBER = "1234567890";

    public static final String ADD = "ADD";
    public static final String UPDATE = "UPDATE";
    public static final String DELETE = "DELETE";
    public static final String ALT_TN_CONTACT_TYPE = "TELEPHONE_NUMBER";
    public static final String ACCT_LOOKUP = "ACCT_LOOKUP";
    public static final String AUTH_CODE = "authenticationCode";
    public static final String SESSION_EMAIL_ADDRESS = "emailAddress";

    public static final String BILLER="daffyduck112233";
    public static final String FIRST_NAME="firstName";
    public static final String LAST_NAME="lastName";
    public static final String COMPANY_OWNER_ID_LOWER_CAMEL_CASE ="companyOwnerId";
    public static final String BILLING_ADDRESS_PRIMARY_LINE="billingAddressPrimaryLine";
    public static final String BILLING_ADDRESS_CITY="billingAddressCity";
    public static final String BILLING_ADDRESS_STATE_CODE="billingAddressStateCode";
    public static final String BILLING_ADDRESS_ZIP="billingAddressZip";
    public static final String BILLING_ADDRESS_ADDRESS_LINE_1="billingAddressAddressLine1";
    public static final String BILLING_ADDRESS_ADDRESS_LINE_2="billingAddressAddressLine2";
    public static final String PAYMENT_DUE_DATE="paymentDueDate";
    public static final String AUTOPAY="autoPay";
    public static final String CONFIRMATION_EMAIL_ADDRESS="confirmationEmailAddress";
    public static final String ADJUSTMENT_AMOUNT="adjustedAmount";
    public static final String USE_YOUR_OWN = "Use Your Own";
    public static final String USER_NAME_KEY = "elmo";
    public static final String ACCOUNT = "Account";
    public static final String WILL_RECEIVE_BILL_EMAIL_NOTIFICATION = "You've successfully submitted your paperless billing enrollment. Thanks for saving trees!";
    public static final String WILL_RECEIVE_PAPER_BILL = "You've successfully submitted a request to unenroll from paperless billing. We'll send you a paper bill in the mail when your next bill is ready. You can change back to paperless billing anytime.";
    public static final String MOBILE_SRC_APP_ID = "CONSMOBILE";
    public static final String SELF_INSTALL_KAFKA = "/dss/publish-self-install-events";
    public static final String SELF_INSTALL_KAFKA1 = "/dss/publish-self-install-events1";
    public static final String SELF_INSTALL_KAFKA2 = "/dss/publish-self-install-events2";
    public static final String PLUME_CALL ="/dss/plume/getToken";
    public static final String DSS_PAYMENT_MANAGEAUTOPAY_PAYMENT = "/dss/epwf/manageAutopay";
    public static final String DSS_PAYMENT_SUBMIT_PAYMENT = "/dss/epwf/getEPWFSubmitPaymentDetails";

    public static final String NBA_MODEM_OFFER_SESSION_PREFIX = "dh-nba-modem-offer-";
    public static final String NBA_SERVICE_CREDIT_OFFER_SESSION_PREFIX = "dh-nba-service-credit-offer-";
    public static final String ACS_NETWORK_READINESS = "/dss/acs/getNetworkReadiness";
    public static final String CGS_IDENTIFY_CUSTOMER = "/digihome/cgs/identifyCustomer?serialId=";
    public static final String MODEM_FIRMWARE_LIST = "data/ModemFirmwareList.json";
    public static final String RELEASE_WALLED_GARDEN = "/dss/improv/releaseFromWalledGarden";
    public static final String SL_SESSION_MODEM_DATA = "SL_SESSION_MODEM";
    public static final String SL_POST_EULA_STATUS = "SL_POST_EULA_STATUS";
    public static final String FIXED_WIRELESS = "FIXED_WIRELESS";
    public static final String REQ_ATTR_USERNAME = "attr_username";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String DATE_TIME_PATTERN ="yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String BUSINESS_EXCEPTION = "BusinessException";
    public static final String SYSTEM_EXCEPTION = "SystemException";
    public static final String ACCOUNT_DATA_SET = "/dss/acs/accountDataSet?withUserName=";
    public static final String GET_PPP_CREDENTIALS = "/dss/acs/getPPPCredentials";
    public static final String GET_CAPTIVE_PORTAL_RELEASE = "/dss/acs/getCaptivePortalRelease";
    public static final String BILL_PDF_SESSION_TIMESTAMP_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String SYSTEM = "elmo";
	public static final String PREPAID_BAID_PREFIX = "PPB";
	public static final String PPP_NOTE_LOGIN = "login";
    public static final String SRVC_CATEGORY_DATA = "DATA";
    public static final String SRVC_CATEGORY_VOICE = "VOICE-HP";
    public static final String ORDER_REF_PREFIX = "ORD-";
    public static final String ORDER_TYPE_CHANGE = "change";
    public static final String MODEM_TYPE_LEASE = "lease";
    public static final String MODEM_TYPE_PURCHASE = "purchase";
    public static final String MODEM_TYPE_BYOM = "byom";
    public static final String SESSION_ACCOUNT_KEY="dh-sessionAccount-";
    public static final String BONDED_TN="BondedTN";
    public static final String WTN="WTN";
}
