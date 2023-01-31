package ru.mos.smart.data.RinRifJson;

import com.google.gson.annotations.SerializedName;

public class Contact{

	@SerializedName("phone")
	private String phone;

	@SerializedName("surname")
	private String surname;

	@SerializedName("name")
	private String name;

	@SerializedName("patronimic")
	private String patronimic;

	@SerializedName("fio")
	private String fio;

	@SerializedName("email")
	private String email;

	public String getPhone(){
		return phone;
	}

	public String getSurname(){
		return surname;
	}

	public String getName(){
		return name;
	}

	public String getPatronimic(){
		return patronimic;
	}

	public String getFio(){
		return fio;
	}

	public String getEmail(){
		return email;
	}
}