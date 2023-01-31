package ru.mos.smart.data.RinRifJson;

import com.google.gson.annotations.SerializedName;

public class ExaminationEcological{

	@SerializedName("isExaminationEcological")
	private boolean isExaminationEcological;

	public boolean isIsExaminationEcological(){
		return isExaminationEcological;
	}
}