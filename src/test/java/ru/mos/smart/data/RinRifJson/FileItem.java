package ru.mos.smart.data.RinRifJson;

import com.google.gson.annotations.SerializedName;

public class FileItem{

	@SerializedName("file")
	private File file;

	@SerializedName("author")
	private Author author;

	public File getFile(){
		return file;
	}

	public Author getAuthor(){
		return author;
	}
}