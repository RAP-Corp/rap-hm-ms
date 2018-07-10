package com.rap.services.models;

import org.springframework.data.annotation.Id;


public class User extends BaseModel{

    @Id
    private String userId;
    private String password;
    private UserName userName;
    private String userEmailAddress;
    private String role;
    private SocialProfile socialProfile;
    private Contact contact;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserName getUserName() {
		return userName;
	}
	public void setUserName(UserName userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public SocialProfile getSocialProfile() {
		return socialProfile;
	}
	public void setSocialProfile(SocialProfile socialProfile) {
		this.socialProfile = socialProfile;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public String getUserEmailAddress() {
		return userEmailAddress;
	}
	public void setUserEmailAddress(String userEmailAddress) {
		this.userEmailAddress = userEmailAddress;
	}

}
