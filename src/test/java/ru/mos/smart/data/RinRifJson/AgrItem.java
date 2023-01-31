package ru.mos.smart.data.RinRifJson;

import com.google.gson.annotations.SerializedName;

public class AgrItem{

	@SerializedName("numberAgr")
	private String numberAgr;

	@SerializedName("dateAgr")
	private String dateAgr;

	public String getNumberAgr(){
		return numberAgr;
	}

	public String getDateAgr(){
		return dateAgr;
	}
}