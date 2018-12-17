package com.bdqn.pojo;

public class BackendUser {
	private int backendId;
	private String backendName;
	private String backendPassword;
	private int	backendRole;
	private String backendRoleName;
	public String getBackendRoleName() {
		return backendRoleName;
	}
	public void setBackendRoleName(String backendRoleName) {
		this.backendRoleName = backendRoleName;
	}
	public int getBackendId() {
		return backendId;
	}
	public void setBackendId(int backendId) {
		this.backendId = backendId;
	}
	public String getBackendName() {
		return backendName;
	}
	public void setBackendName(String backendName) {
		this.backendName = backendName;
	}
	public String getBackendPassword() {
		return backendPassword;
	}
	public void setBackendPassword(String backendPassword) {
		this.backendPassword = backendPassword;
	}
	public int getBackendRole() {
		return backendRole;
	}
	public void setBackendRole(int backendRole) {
		this.backendRole = backendRole;
	}
	
}
