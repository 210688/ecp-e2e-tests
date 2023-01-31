package ru.mos.smart.data.RinRifJson;

import com.google.gson.annotations.SerializedName;

public class BuildingPermit{

	@SerializedName("bleaseExtend")
	private String bleaseExtend;

	@SerializedName("buildingPermitNumber")
	private String buildingPermitNumber;

	public String getBleaseExtend(){
		return bleaseExtend;
	}

	public String getBuildingPermitNumber(){
		return buildingPermitNumber;
	}
}