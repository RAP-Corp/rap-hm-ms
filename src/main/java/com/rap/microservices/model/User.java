package com.rap.microservices.model;

import org.springframework.data.annotation.Id;

import java.util.Set;


public class User extends BaseModel{

    @Id
    private String userId;
    private String password;
    private UserName userName;
	//@Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)
	private String email;
	private Set<String> roles;
    private SocialProfile socialProfile;
    private Contact contact;
	private boolean enabled;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<String> getRoles() {
		return roles;
	}

	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
}
