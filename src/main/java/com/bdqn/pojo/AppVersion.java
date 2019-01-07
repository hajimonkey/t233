package com.bdqn.pojo;

import java.util.Date;

public class AppVersion {
	private int verId;
	private String verSn;
	private int verState;
	private String verDesc;
	private String verApk;
	private int verAppId;
	private int verCreatedBy;
	private Date verCreationDate;
	private int verModifyBy;
	private Date verModifyDate;
	private String verStatename;
	private String softwarename;
	private int verSize;
	
	public int getVerSize() {
		return verSize;
	}
	public void setVerSize(int verSize) {
		this.verSize = verSize;
	}
	public String getSoftwarename() {
		return softwarename;
	}
	public void setSoftwarename(String softwarename) {
		this.softwarename = softwarename;
	}
	public String getVerStatename() {
		return verStatename;
	}
	public void setVerStatename(String verStatename) {
		this.verStatename = verStatename;
	}
	public int getVerId() {
		return verId;
	}
	public void setVerId(int verId) {
		this.verId = verId;
	}
	public String getVerSn() {
		return verSn;
	}
	public void setVerSn(String verSn) {
		this.verSn = verSn;
	}
	public int getVerState() {
		return verState;
	}
	public void setVerState(int verState) {
		this.verState = verState;
	}
	public String getVerDesc() {
		return verDesc;
	}
	public void setVerDesc(String verDesc) {
		this.verDesc = verDesc;
	}
	public String getVerApk() {
		return verApk;
	}
	public void setVerApk(String verApk) {
		this.verApk = verApk;
	}
	public int getVerAppId() {
		return verAppId;
	}
	public void setVerAppId(int verAppId) {
		this.verAppId = verAppId;
	}
	public int getVerCreatedBy() {
		return verCreatedBy;
	}
	public void setVerCreatedBy(int verCreatedBy) {
		this.verCreatedBy = verCreatedBy;
	}
	public Date getVerCreationDate() {
		return verCreationDate;
	}
	public void setVerCreationDate(Date verCreationDate) {
		this.verCreationDate = verCreationDate;
	}
	public int getVerModifyBy() {
		return verModifyBy;
	}
	public void setVerModifyBy(int verModifyBy) {
		this.verModifyBy = verModifyBy;
	}
	public Date getVerModifyDate() {
		return verModifyDate;
	}
	public void setVerModifyDate(Date verModifyDate) {
		this.verModifyDate = verModifyDate;
	}
	
}
