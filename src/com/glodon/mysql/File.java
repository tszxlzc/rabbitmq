package com.glodon.mysql;

import java.util.Date;

public class File {
	private String fileID;
	private String fileOfUserID;
	private String fileName;
	private int fileSize;
	private Date fileTime;
	private String filePath;
	public String getFileID() {
		return fileID;
	}
	public void setFileID(String fileID) {
		this.fileID = fileID;
	}
	public String getFileOfUserID() {
		return fileOfUserID;
	}
	public void setFileOfUserID(String fileOfUserID) {
		this.fileOfUserID = fileOfUserID;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getFileSize() {
		return fileSize;
	}
	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}
	public Date getFileTime() {
		return fileTime;
	}
	public void setFileTime(Date fileTime) {
		this.fileTime = fileTime;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
}
