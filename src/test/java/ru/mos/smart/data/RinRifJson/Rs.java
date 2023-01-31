package ru.mos.smart.data.RinRifJson;

import com.google.gson.annotations.SerializedName;

public class Rs{

	@SerializedName("request")
	private Request request;

	@SerializedName("serviceNumber")
	private String serviceNumber;

	@SerializedName("incomingData")
	private IncomingData incomingData;

	@SerializedName("reestrRegNumber")
	private String reestrRegNumber;

	@SerializedName("rsDocument")
	private RsDocument rsDocument;

	@SerializedName("documentId")
	private String documentId;

	@SerializedName("applicantOrgId")
	private String applicantOrgId;

	@SerializedName("folderId")
	private String folderId;

	@SerializedName("planDate")
	private PlanDate planDate;

	@SerializedName("pgu")
	private Pgu pgu;

	@SerializedName("status")
	private Status status;

	public Request getRequest(){
		return request;
	}

	public String getServiceNumber(){
		return serviceNumber;
	}

	public IncomingData getIncomingData(){
		return incomingData;
	}

	public String getReestrRegNumber(){
		return reestrRegNumber;
	}

	public RsDocument getRsDocument(){
		return rsDocument;
	}

	public String getDocumentId(){
		return documentId;
	}

	public String getApplicantOrgId(){
		return applicantOrgId;
	}

	public String getFolderId(){
		return folderId;
	}

	public PlanDate getPlanDate(){
		return planDate;
	}

	public Pgu getPgu(){
		return pgu;
	}

	public Status getStatus(){
		return status;
	}
}