package ru.mos.smart.data.RinRifJson;

import com.google.gson.annotations.SerializedName;

public class Author{

	@SerializedName("login")
	private String login;

	@SerializedName("fioFull")
	private String fioFull;

	public String getLogin(){
		return login;
	}

	public String getFioFull(){
		return fioFull;
	}
}