package ru.mos.smart.data.RinRifJson;

import com.google.gson.annotations.SerializedName;

public class Pgu{

	@SerializedName("ssoid")
	private String ssoid;

	@SerializedName("pguRegDate")
	private String pguRegDate;

	@SerializedName("requestMessageId")
	private int requestMessageId;

	@SerializedName("pguRegNum")
	private String pguRegNum;

	public String getSsoid(){
		return ssoid;
	}

	public String getPguRegDate(){
		return pguRegDate;
	}

	public int getRequestMessageId(){
		return requestMessageId;
	}

	public String getPguRegNum(){
		return pguRegNum;
	}
}