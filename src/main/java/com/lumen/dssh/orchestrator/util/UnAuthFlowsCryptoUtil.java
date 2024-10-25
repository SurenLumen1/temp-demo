package com.lumen.dssh.orchestrator.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Component
public class UnAuthFlowsCryptoUtil {

    private static final Logger logger = LogManager.getLogger();
    private static final String UNAUTH_FLOWS_KEY = "OrO04gj9h3PoQYlV";
    private static final String UNAUTH_FLOWS_IV = "PqI84hj3h2SoDY0V";

    public String decryptAppKey(String encryptedAppKey) {
        String decryptedValue = null;
        try {

            Base64.Decoder decoder = Base64.getDecoder();
            byte[] encrypted1 = decoder.decode(encryptedAppKey);

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(UNAUTH_FLOWS_KEY.getBytes(), "AES");//NOSONAR
            IvParameterSpec ivspec = new IvParameterSpec(UNAUTH_FLOWS_IV.getBytes());  //NOSONAR

            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            decryptedValue = originalString.trim();
        } catch (Exception e) {
            logger.error("decryptAppKey():: Error occurred while decrypting app key={}", encryptedAppKey);
        }
        return decryptedValue;
    }
}
