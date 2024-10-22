package com.lumen.dssh.orchestrator.util;

import java.nio.charset.StandardCharsets;

import org.jasypt.contrib.org.apache.commons.codec_1_3.binary.Base64;

public class RestServiceUtils {
	private RestServiceUtils() {		
	}

    public static String getApiGeeAuth(String encValue) {

        String auth = "digihome" + ":" + encValue;
        byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(StandardCharsets.US_ASCII));

        return "Basic " + new String(encodedAuth);
    }

}
