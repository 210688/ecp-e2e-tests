package ru.mos.smart.data.RinRifJson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Object{

	@SerializedName("typeConstruction")
	private TypeConstruction typeConstruction;

	@SerializedName("objectCadNumber")
	private List<String> objectCadNumber;

	@SerializedName("scopeConstruction")
	private ScopeConstruction scopeConstruction;

	@SerializedName("address")
	private List<AddressItem> address;

	@SerializedName("addressType")
	private String addressType;

	@SerializedName("fullNameObject")
	private String fullNameObject;

	@SerializedName("objectType")
	private ObjectType objectType;

	public TypeConstruction getTypeConstruction(){
		return typeConstruction;
	}

	public List<String> getObjectCadNumber(){
		return objectCadNumber;
	}

	public ScopeConstruction getScopeConstruction(){
		return scopeConstruction;
	}

	public List<AddressItem> getAddress(){
		return address;
	}

	public String getAddressType(){
		return addressType;
	}

	public String getFullNameObject(){
		return fullNameObject;
	}

	public ObjectType getObjectType(){
		return objectType;
	}
}