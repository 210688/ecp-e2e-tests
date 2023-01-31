package ru.mos.smart.data.RinRifJson;

import com.google.gson.annotations.SerializedName;

public class ZuRightsItem{

	@SerializedName("zuStatus")
	private ZuStatus zuStatus;

	@SerializedName("specialStatus")
	private SpecialStatus specialStatus;

	@SerializedName("withdrawalLand")
	private boolean withdrawalLand;

	@SerializedName("plot_locatedGuid")
	private String plotLocatedGuid;

	public ZuStatus getZuStatus(){
		return zuStatus;
	}

	public SpecialStatus getSpecialStatus(){
		return specialStatus;
	}

	public boolean isWithdrawalLand(){
		return withdrawalLand;
	}

	public String getPlotLocatedGuid(){
		return plotLocatedGuid;
	}
}