package com.lumen.dssh.orchestrator.common;

import java.io.FileNotFoundException;
import java.io.Serializable;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import com.lumen.dssh.orchestrator.handler.mobile.ModemBusinessHandler;
import com.lumen.dssh.orchestrator.util.CommonUtilities;

public class ModemFirmWareInfo implements Serializable {
	private static final long serialVersionUID = 1952232848601614770L;
	private static JsonObject modemList;
	public static JsonObject getModemList() throws JsonIOException, JsonSyntaxException, FileNotFoundException {
		JsonObject modemListJson = null;
		if (modemList == null) {
			String modemListString = CommonUtilities.readFileResource(ModemBusinessHandler.class, CommonStrings.MODEM_FIRMWARE_LIST);
			modemListJson = (JsonObject) CommonUtilities.toObject(modemListString, JsonObject.class);
			setModemList(modemListJson);
		}
		return modemList;
	}
	public static void resetVersionCheck()  {
		if(modemList!=null) {
			modemList = null;
		}
	}
	public static void setModemList(JsonObject newModemList) {
		modemList = newModemList;
	}
}
