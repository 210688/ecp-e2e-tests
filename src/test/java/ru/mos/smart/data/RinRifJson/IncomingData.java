package ru.mos.smart.data.RinRifJson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IncomingData{

	@SerializedName("buildingPermit")
	private BuildingPermit buildingPermit;

	@SerializedName("goal")
	private Goal goal;

	@SerializedName("requestDocument")
	private List<RequestDocumentItem> requestDocument;

	@SerializedName("isdownloadPD")
	private boolean isdownloadPD;

	@SerializedName("isdevelopmentTerritoryOld")
	private boolean isdevelopmentTerritoryOld;

	@SerializedName("agr")
	private List<AgrItem> agr;

	@SerializedName("ispermissionDeviateLimit")
	private boolean ispermissionDeviateLimit;

	@SerializedName("applicant")
	private Applicant applicant;

	@SerializedName("delegate")
	private Delegate delegate;

	@SerializedName("isdevelopmentTerritory")
	private boolean isdevelopmentTerritory;

	@SerializedName("changesType")
	private List<ChangesTypeItem> changesType;

	@SerializedName("reconstructionStateCustomer")
	private boolean reconstructionStateCustomer;

	@SerializedName("oivCode")
	private OivCode oivCode;

	@SerializedName("urbanPlanningDocumentation")
	private List<UrbanPlanningDocumentationItem> urbanPlanningDocumentation;

	@SerializedName("examinationEcological")
	private ExaminationEcological examinationEcological;

	@SerializedName("isExamination")
	private boolean isExamination;

	@SerializedName("changesTypeNote")
	private String changesTypeNote;

	@SerializedName("object")
	private Object object;

	@SerializedName("zuRights")
	private List<ZuRightsItem> zuRights;

	public BuildingPermit getBuildingPermit(){
		return buildingPermit;
	}

	public Goal getGoal(){
		return goal;
	}

	public List<RequestDocumentItem> getRequestDocument(){
		return requestDocument;
	}

	public boolean isIsdownloadPD(){
		return isdownloadPD;
	}

	public boolean isIsdevelopmentTerritoryOld(){
		return isdevelopmentTerritoryOld;
	}

	public List<AgrItem> getAgr(){
		return agr;
	}

	public boolean isIspermissionDeviateLimit(){
		return ispermissionDeviateLimit;
	}

	public Applicant getApplicant(){
		return applicant;
	}

	public Delegate getDelegate(){
		return delegate;
	}

	public boolean isIsdevelopmentTerritory(){
		return isdevelopmentTerritory;
	}

	public List<ChangesTypeItem> getChangesType(){
		return changesType;
	}

	public boolean isReconstructionStateCustomer(){
		return reconstructionStateCustomer;
	}

	public OivCode getOivCode(){
		return oivCode;
	}

	public List<UrbanPlanningDocumentationItem> getUrbanPlanningDocumentation(){
		return urbanPlanningDocumentation;
	}

	public ExaminationEcological getExaminationEcological(){
		return examinationEcological;
	}

	public boolean isIsExamination(){
		return isExamination;
	}

	public String getChangesTypeNote(){
		return changesTypeNote;
	}

	public Object getObject(){
		return object;
	}

	public List<ZuRightsItem> getZuRights(){
		return zuRights;
	}
}