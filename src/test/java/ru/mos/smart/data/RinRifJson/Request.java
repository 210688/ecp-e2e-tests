package ru.mos.smart.data.RinRifJson;

import com.google.gson.annotations.SerializedName;

public class Request{

	@SerializedName("regNumber")
	private String regNumber;

	@SerializedName("requestType")
	private RequestType requestType;

	@SerializedName("regDate")
	private String regDate;

	@SerializedName("source")
	private Source source;

	public String getRegNumber(){
		return regNumber;
	}

	public RequestType getRequestType(){
		return requestType;
	}

	public String getRegDate(){
		return regDate;
	}

	public Source getSource(){
		return source;
	}
}