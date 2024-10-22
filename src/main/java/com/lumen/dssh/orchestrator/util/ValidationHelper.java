package com.lumen.dssh.orchestrator.util;

import com.lumen.dssh.orchestrator.common.CommonStrings;
import com.lumen.dssh.orchestrator.common.ValidationStrings;
import com.lumen.dssh.orchestrator.model.UnAuthFlowsValidationResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class ValidationHelper {

    private static final Logger logger = LogManager.getLogger();
    private static final int DIFF_IN_SEC_BTN_UI_ORCH = 60;

    @Value("${unauth.passphase}")
    private String unAuthPassPhase;

    @Autowired
    UnAuthFlowsCryptoUtil unAuthFlowsCryptoUtil;
	
	private ValidationHelper() {		
	}
        /**
         * this method is used to check if the given string is not null, and is between the given range.
         * If it satisfies the above condition it returns true else false.
         *
         * @param value
         * @param minLength
         * @param maxLength
         * @return boolean
         */
        public boolean validateLength(String value, int minLength, int maxLength) {
            if (value != null && value.trim().length() >= minLength && value.trim().length() <= maxLength) {
                return true;
            }
            return false;
        }

    public boolean isValidEmailAddress(String emailAddress ) {
        if (StringUtils.isEmpty(emailAddress)) {
            return false;
        }
        emailAddress = emailAddress.trim();
        Pattern pattern = Pattern.compile(CommonStrings.EMAIL_REGEX);
        boolean noInvalidDblCheck =
                (emailAddress.indexOf(CommonStrings.DBL_DASH) == CommonStrings.NOT_FOUND_IDX)
                        && (emailAddress.indexOf(CommonStrings.DBL_PERIOD) == CommonStrings.NOT_FOUND_IDX)
                        && (emailAddress.indexOf(CommonStrings.DBL_UNDERSCORE) == CommonStrings.NOT_FOUND_IDX)
                        && (emailAddress.indexOf(CommonStrings.DBL_PLUS) == CommonStrings.NOT_FOUND_IDX);
        Matcher matcher = pattern.matcher(emailAddress);
        return matcher.matches() && noInvalidDblCheck;
    }

    public boolean isAlphaNumericAccount(String value) {
        if (!StringUtils.isEmpty(value) && value.trim().matches("[A-Za-z0-9]+")) {
            return true;
        }
        return false;
    }
    public String sanitizeAccountNumber(String accountNumber){
        if(StringUtils.isNotBlank(accountNumber)) {
            return accountNumber.replaceAll(ValidationStrings.ACCOUNT_NUMBER_VALIDATION_REGEX, "");
        }
        return "";
    }

    public boolean compareDates(String toCompareDate) {
       try {
           //2023-06-12T10:49:10.123Z
            OffsetDateTime givenOffsetDateTime = OffsetDateTime.parse(toCompareDate);
            // get the current date and time in the same zone (UTC)
            OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);
            return now.minusDays(2).isAfter(givenOffsetDateTime);
       }catch (Exception e) {
           //2023-06-12T10:49:010Z
           StringBuilder string = new StringBuilder(toCompareDate);
           String givenDate = string.deleteCharAt(17).toString();
           ZonedDateTime givenDateTime = ZonedDateTime.parse(givenDate, DateTimeFormatter.ISO_DATE_TIME);
           ZonedDateTime currentDateTime = ZonedDateTime.now();
           long daysDifference = ChronoUnit.DAYS.between(givenDateTime, currentDateTime);
           return daysDifference >= 2;
       }
    }

    public UnAuthFlowsValidationResponse validateAppKey(String encryptedAppKey) {
        UnAuthFlowsValidationResponse unAuthFlowsValidationResponse;
        String decryptedAppkey = unAuthFlowsCryptoUtil.decryptAppKey(encryptedAppKey);
        if (decryptedAppkey != null) {
            unAuthFlowsValidationResponse = processAppKey(encryptedAppKey, decryptedAppkey);
            logger.info("validateAppKey()::encrypted AppKey={}, decrypted AppKey={}, validation response={}", encryptedAppKey, decryptedAppkey, unAuthFlowsValidationResponse);
        } else {
            logger.error("validateAppKey()::Not able to decrypt AppKey={}", encryptedAppKey);
            unAuthFlowsValidationResponse = new UnAuthFlowsValidationResponse(false, "");
        }
        return unAuthFlowsValidationResponse;
    }

    private UnAuthFlowsValidationResponse processAppKey(String encryptedAppKey, String decryptedAppkey) {

        String ipAddress = null;
        boolean validAppKey;

        List<String> appKeyElements = Arrays.asList(decryptedAppkey.split("\\|"));

        if (appKeyElements.size() == 3) {
            boolean isValid = checkTimeOfUnauthFLows(encryptedAppKey, decryptedAppkey, appKeyElements.get(0));
            if (isValid) {
                isValid = ipValidation(appKeyElements.get(1));
                if (isValid) {
                    isValid = passphaseValidation(appKeyElements.get(2));
                    if (isValid) {
                        validAppKey = true;
                        ipAddress = appKeyElements.get(1);
                    } else {
                        logger.error("processAppKey():: passphase validation fails for encryptedKey={}, decryptedKey={}", encryptedAppKey, decryptedAppkey);
                        validAppKey = false;
                    }
                } else {
                    logger.error("processAppKey():: ip validation fails for encryptedKey={}, decryptedKey={}", encryptedAppKey, decryptedAppkey);
                    validAppKey = false;
                }
            } else {
                logger.error("processAppKey():: time validation fails for encryptedKey={}, decryptedKey={}", encryptedAppKey, decryptedAppkey);
                validAppKey = false;
            }
        } else {
            logger.error("processAppKey():: Components validation fails for encryptedKey={}, decryptedKey={}", encryptedAppKey, decryptedAppkey);
            validAppKey = false;
        }

        return new UnAuthFlowsValidationResponse(validAppKey, ipAddress);
    }

    private boolean passphaseValidation(String s) {
        return s.equals(unAuthPassPhase);
    }

    private boolean ipValidation(String s) {
        Pattern pattern = Pattern.compile("^(\\d|[1-9]\\d|1\\d\\d|2([0-4]\\d|5[0-5]))\\.(\\d|[1-9]\\d|1\\d\\d|2([0-4]\\d|5[0-5]))\\.(\\d|[1-9]\\d|1\\d\\d|2([0-4]\\d|5[0-5]))\\.(\\d|[1-9]\\d|1\\d\\d|2([0-4]\\d|5[0-5]))$");//NOSONAR
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }

    private boolean checkTimeOfUnauthFLows(String encryptedAppKey, String decryptedAppkey, String t1) {
        boolean valid;
        SimpleDateFormat dateFormat = new SimpleDateFormat(ValidationStrings.UNAUTH_FLOWS_TIMESTAMP_FORMAT);
        String t2 =dateFormat.format(new Date());
        try {
            long differenceInSeconds = (dateFormat.parse(t2).getTime() - dateFormat.parse(t1).getTime())/1000;
            logger.info("checkTimeOfUnauthFLows()::encryptedAppKey={}, decryptedAppKey={}, UI time={}, Orch time={}, time differnece in secs={}", encryptedAppKey, decryptedAppkey, t1, t2, differenceInSeconds);
            if (differenceInSeconds <= DIFF_IN_SEC_BTN_UI_ORCH) {
                valid = true;
            } else {
                valid = false;
            }
        } catch (ParseException e) {
            valid = false;
        }
        return valid;
    }

}
