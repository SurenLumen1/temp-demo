package com.lumen.dssh.orchestrator.util;

import java.util.Base64;
import java.util.Base64.Decoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AESUtil {
	
	private AESUtil() {
		
	}
	
	private static final String KEY = "hPO0432hpoQYVMsw";

    private static final Logger logger = LogManager.getLogger();

	public static String decrypt(String encryptedValue) {
		String decryptedValue = null;
		try {
			String iv = "AEsR7865hklP04jP";

			Decoder decoder = Base64.getDecoder();
			byte[] encrypted1 = decoder.decode(encryptedValue);

			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			SecretKeySpec keyspec = new SecretKeySpec(KEY.getBytes(), "AES");//NOSONAR
			IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());  //NOSONAR

			cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

			byte[] original = cipher.doFinal(encrypted1);
			String originalString = new String(original);
			decryptedValue = originalString.trim();
			logger.debug("encrypt()::Successfully decrypted value received from user");
		} catch (Exception e) {
			logger.error("encrypt():: Error occurred while decrypting sensitive value received from user::{}",e.getLocalizedMessage());
		}
		return decryptedValue;
	}

}

