package ru.mos.smart.data.RinRifJson;

import com.google.gson.annotations.SerializedName;

public class Applicant{

	@SerializedName("ogrn")
	private String ogrn;

	@SerializedName("orgType")
	private OrgType orgType;

	@SerializedName("orgRole")
	private OrgRole orgRole;

	@SerializedName("isFirstPerson")
	private IsFirstPerson isFirstPerson;

	@SerializedName("phone")
	private String phone;

	@SerializedName("contact")
	private Contact contact;

	@SerializedName("inn")
	private String inn;

	@SerializedName("orgFullName")
	private String orgFullName;

	@SerializedName("orgShortName")
	private String orgShortName;

	@SerializedName("email")
	private String email;

	public String getOgrn(){
		return ogrn;
	}

	public OrgType getOrgType(){
		return orgType;
	}

	public OrgRole getOrgRole(){
		return orgRole;
	}

	public IsFirstPerson getIsFirstPerson(){
		return isFirstPerson;
	}

	public String getPhone(){
		return phone;
	}

	public Contact getContact(){
		return contact;
	}

	public String getInn(){
		return inn;
	}

	public String getOrgFullName(){
		return orgFullName;
	}

	public String getOrgShortName(){
		return orgShortName;
	}

	public String getEmail(){
		return email;
	}
}