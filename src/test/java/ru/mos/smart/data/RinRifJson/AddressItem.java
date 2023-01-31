package ru.mos.smart.data.RinRifJson;

import com.google.gson.annotations.SerializedName;

public class AddressItem{

	@SerializedName("prefect")
	private Prefect prefect;

	@SerializedName("district")
	private District district;

	@SerializedName("landmarkInfo")
	private String landmarkInfo;

	public Prefect getPrefect(){
		return prefect;
	}

	public District getDistrict(){
		return district;
	}

	public String getLandmarkInfo(){
		return landmarkInfo;
	}
}