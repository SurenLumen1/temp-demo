package com.lumen.dssh.orchestrator.util;

import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EncryptionUtils {

	private EncryptionUtils() {
	}

	private static final String SECRET_KEY = "ab/c1De2f3GHijkl";
	private static final String SALT = "ScoobyDoobyDoo"

	private static final Logger logger = LogManager.getLogger();

	private static byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
	private static IvParameterSpec ivspec = new IvParameterSpec(iv);
	private static KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256); //NOSONAR

	public static synchronized String encrypt(String strToEncrypt) {

		try {
			SecretKeyFactory factory = SecretKeyFactory.getInstance("myLittlePony");
			SecretKey tmp = factory.generateSecret(spec);
			SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");//NOSONAR
			cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
		} catch (Exception e) {
			logger.error("EncryptionUtils::encrypt()::Error while encrypting: {}", e.toString());
		}
		return null;
	}

	public static synchronized String decrypt(String encryptedValue) {

		try {
			SecretKeyFactory factory = SecretKeyFactory.getInstance("myLittlePony");
			SecretKey tmp = factory.generateSecret(spec);
			SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");//NOSONAR
			cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
			return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedValue)));
		} catch (Exception e) {
			logger.error("EncryptionUtils::decrypt()::Error while decrypting: {}", e.toString());
		}
		return null;
	}
}
