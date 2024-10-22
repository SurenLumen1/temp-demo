package com.lumen.dssh.orchestrator.util;

import com.google.gson.Gson;
import com.google.json.JsonSanitizer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class CommonUtilities {

	private CommonUtilities() {

	}

	/**
	 * "^[a-zA-Z0-9&=]+$" - characters from A to Z, a to z or 0 to 0 or & or = from
	 * start to ends of the line with multiple times if these characters are present
	 * then return true else returns false
	 *
	 */
	public static boolean queryStringValidation(String target) {
		boolean flag = false;

		if (StringUtils.isNotBlank(target) && target.matches("^[a-zA-Z0-9&=]+$")) {
			flag = true;
		}

		return flag;
	}


	/**
	 * Convert given object in JSON format
	 *
	 * @param objIn
	 * @return
	 */
	public static String toJSON(Object objIn) {
		Gson gson = new Gson();
		String jsonOut = gson.toJson(objIn);
		return JsonSanitizer.sanitize(jsonOut);
	}


	/**
	 * Convert JSON input to object
	 *
	 * @param jsonInput
	 * @param clazz
	 * @return
	 */
	public static <T> Object toObject(String jsonInput, Class<T> clazz) {
		Gson gson = new Gson();
		String jsonIn = JsonSanitizer.sanitize(jsonInput);
		return gson.fromJson(jsonIn, clazz);
	}

	public static boolean queryStringValidationAndLengthCheck(String sourceValue){
        return queryStringValidation(sourceValue) && sourceValue.length() <= 15;
    }

	public String formatDeliveryEstimateDate(String dt) throws ParseException {
		String strDate = null;
		char iso8601Date = dt.charAt(10);
		SimpleDateFormat formatter6 = null;
		if (iso8601Date == 'T') {
			formatter6 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		} else {
			formatter6 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		}
		Date date = formatter6.parse(dt);
		DateFormat dayFormat = new SimpleDateFormat("MMMMM d");
		DateFormat timeFormat = new SimpleDateFormat("h a");
		String stringDate = dayFormat.format(date);
		String stringTime = timeFormat.format(date);
		strDate = stringDate + "," + stringTime;
		return strDate;
	}
	public String maskAccountNumber(String accountNumber){
		 if(StringUtils.isNotBlank(accountNumber) && accountNumber.length()>4){
			 return "****"+accountNumber.substring(accountNumber.length()-4);
		 }
		 return null;
	}
	public String generateUniqueKeyForAccount(){
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static boolean isAlphaNumericAndColon(String target) {
		return (StringUtils.isNotBlank(target) && target.matches("^[a-zA-Z0-9\\:]+$"));
	}


	public static String readFileResource(Class<?> classRef, String filename) {
		String resourceStr = null;
		InputStream is = classRef.getResourceAsStream("/" + filename);
		assert is != null;
		resourceStr = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8)).lines()
				.collect(Collectors.joining("\n"));
		return resourceStr;
	}

	public static String readFileResourceMsgHandler(Class<?> classRef, String filename) {
		String resourceStr = null;
		InputStream is = classRef.getResourceAsStream(filename);
		assert is != null;
		resourceStr = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8)).lines()
				.collect(Collectors.joining("\n"));
		return resourceStr;
	}
}