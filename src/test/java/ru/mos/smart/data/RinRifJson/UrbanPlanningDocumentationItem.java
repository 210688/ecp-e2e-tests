package ru.mos.smart.data.RinRifJson;

import com.google.gson.annotations.SerializedName;

public class UrbanPlanningDocumentationItem{

	@SerializedName("NumberGpzu")
	private String numberGpzu;

	public String getNumberGpzu(){
		return numberGpzu;
	}
}