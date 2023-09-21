package ru.mos.smart.data.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FormOpportunities{

	@JsonProperty("ord")
	private Integer ord;

	@JsonProperty("code")
	private String code;

	@JsonProperty("author")
	private String author;

	@JsonProperty("localizedNames")
	private List<Object> localizedNames;

	@JsonProperty("description")
	private Object description;

	@JsonProperty("parentId")
	private Integer parentId;

	@JsonProperty("objectType")
	private String objectType;

	@JsonProperty("objectVersion")
	private Integer objectVersion;

	@JsonProperty("permissions")
	private String permissions;

	@JsonProperty("changeDate")
	private String changeDate;

	@JsonProperty("name")
	private String name;

	@JsonProperty("guid")
	private String guid;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("createDate")
	private String createDate;

	public String getCode() {
		return code;
	}

	public String getPermissions() {
		return permissions;
	}

	public String getName() {
		return name;
	}
}