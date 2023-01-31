package ru.mos.smart.data.RinRifJson;

import com.google.gson.annotations.SerializedName;

public class Status{

	@SerializedName("statusDate")
	private static String statusDate;

	@SerializedName("accountName")
	private String accountName;

	@SerializedName("statusName")
	private String statusName;

	@SerializedName("statusCode")
	private static String statusCode;

	public static String getStatusDate(){
		return statusDate;
	}

	public String getAccountName(){
		return accountName;
	}

	public String getStatusName(){
		return statusName;
	}

	public static String getStatusCode(){
		return statusCode;
	}
}