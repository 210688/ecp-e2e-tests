package ru.mos.smart.data.RinRifJson;

import com.google.gson.annotations.SerializedName;

public class File{

	@SerializedName("objectGuid")
	private String objectGuid;

	public String getObjectGuid(){
		return objectGuid;
	}
}