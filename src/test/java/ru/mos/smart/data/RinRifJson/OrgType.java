package ru.mos.smart.data.RinRifJson;

import com.google.gson.annotations.SerializedName;

public class OrgType{

	@SerializedName("code")
	private String code;

	@SerializedName("name")
	private String name;

	public String getCode(){
		return code;
	}

	public String getName(){
		return name;
	}
}