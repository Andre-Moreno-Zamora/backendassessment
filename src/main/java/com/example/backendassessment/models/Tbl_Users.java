package com.example.backendassessment.models;

public class Tbl_Users {

	private int userId;
	private String userName;
	private String password;
	private String status;
	private String createdDate;
	private String updateDate;
	private String login;
	private int profileId;

	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}


	public String getUpdateDate() {
		return updateDate;
	}


	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public int getProfileId() {
		return profileId;
	}


	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	
	
	public String toString() {
		return "Tbl_Users [userId=" + userId 
							+ ", userName =" + userName 
							+ ", password=" + password 
							+ ", status =" + status 
							+ ", createdDate=" + createdDate 
							+ ", updateDate=" + updateDate 
							+ ", login=" + login 
							+ ", profileId=" + profileId + "]";
	}
}
