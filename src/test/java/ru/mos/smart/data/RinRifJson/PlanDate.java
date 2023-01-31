package ru.mos.smart.data.RinRifJson;

import com.google.gson.annotations.SerializedName;

public class PlanDate{

	@SerializedName("actualPlanDate")
	private String actualPlanDate;

	public String getActualPlanDate(){
		return actualPlanDate;
	}
}