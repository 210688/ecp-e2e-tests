package ru.mos.smart.data.RinRifJson;

import com.google.gson.annotations.SerializedName;

public class Response{

	@SerializedName("rs")
	private Rs rs;

	@SerializedName("id")
	private String id;

	@SerializedName("folderId")
	private String folderId;

	public Rs getRs(){
		return rs;
	}

	public String getId(){
		return id;
	}

	public String getFolderId(){
		return folderId;
	}
}