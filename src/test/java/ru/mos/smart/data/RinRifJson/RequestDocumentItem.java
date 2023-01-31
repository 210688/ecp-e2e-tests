package ru.mos.smart.data.RinRifJson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RequestDocumentItem{

	@SerializedName("file")
	private List<FileItem> file;

	@SerializedName("docType")
	private DocType docType;

	@SerializedName("docDate")
	private String docDate;

	@SerializedName("docNumber")
	private String docNumber;

	public List<FileItem> getFile(){
		return file;
	}

	public DocType getDocType(){
		return docType;
	}

	public String getDocDate(){
		return docDate;
	}

	public String getDocNumber(){
		return docNumber;
	}
}