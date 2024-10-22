package com.lumen.dssh.orchestrator.util;

import com.lumen.dssh.orchestrator.model.mobile.selfInstall.MessageContent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class MessageContentHandler {
	private static final Logger logger = LogManager.getLogger();
	public static final String DB_MESSAGE_1_FILE = "DB_MESSAGE_1.txt";
	public static final String DB_MESSAGE_2_FILE = "DB_MESSAGE_2.txt";
	public static final String ACS_MESSAGE_1_FILE = "ACS_MESSAGE_1.txt";
	public static final String EULA_MESSAGE_1_FILE = "EULA_MESSAGE_1.txt";
	public static final String EULA_MESSAGE_2_FILE = "EULA_MESSAGE_2.txt";
	public static final String ACS_MESSAGE_2_FILE = "ACS_MESSAGE_2.txt";
	public static final String ACS_MESSAGE_3_FILE = "ACS_MESSAGE_3.txt";
	public static final String ACS_MESSAGE_4_FILE = "ACS_MESSAGE_4.txt";
	public static final String ACS_MESSAGE_5_FILE = "ACS_MESSAGE_5.txt";
	public static final String IMPROV_MESSAGE_1_FILE = "IMPROV_MESSAGE_1.txt";
	public static final String PERSONAILZE_WIFI_1_FILE = "WIFI_MESSAGE_1.txt";
	public static final String PERSONAILZE_WIFI_2_FILE = "WIFI_MESSAGE_2.txt";
	public static final String PERSONAILZE_WIFI_3_FILE = "WIFI_MESSAGE_3.txt";
	public static final String CGS_MESSAGE_1_FILE = "CGS_MESSAGE_1.txt";
	public static final String SELF_INSTALL_NETWORK_READINESS_FILE = "SELF_INSTALL_NETWORK_READINESS.txt";
	
	private static final String MESSAGE_TEXT_PATH = "/data/statictext/";
	
	private MessageContentHandler() {
	}
	
	public static MessageContent getMessageContent(String fileName) {
		String messageContent = CommonUtilities.readFileResourceMsgHandler(MessageContentHandler.class,MESSAGE_TEXT_PATH +fileName);
		logger.info("getMessageContent messageContent is: {}",messageContent);
		return (MessageContent) CommonUtilities.toObject(messageContent, MessageContent.class);
	}
	
	public static String readInMessageContent(String fileName) {
		StringBuilder responseBuilder= new StringBuilder();
		BufferedReader in = null;
		try {
			File msgFile = new File(MESSAGE_TEXT_PATH + fileName);
			in = new BufferedReader(new InputStreamReader(new FileInputStream(msgFile)));
	        String inputLine;
	        while ((inputLine = in.readLine()) != null) {
				responseBuilder.append(inputLine);
	        }
	        in.close();
		} catch (IOException e) {
			logger.error("IOException while reading the message file: "+e.getMessage());
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch (IOException e) {
					logger.error("IOException while closing the message file: "+e.getMessage());
				}
			}
		}

		return responseBuilder.toString();
	}
}
