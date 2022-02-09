package com.example.backendassessment.models;

public class Tbl_Profiles {

	private int profileId;
	private String profile;
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	public String toString() {
		return "Tbl_Profiles [profileId=" + profileId + ", profile=" + profile + "]";
	}
	
}
