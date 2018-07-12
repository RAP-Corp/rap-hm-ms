package com.rap.microservices.model;

import java.util.List;

import org.springframework.data.annotation.Id;


public class Requisition extends BaseModel{
	
	@Id
	private String requisitionId;
	private String clientName;
	private String clientHiringManager;
	private String clientProjectManager;
	private String clientProjectDescription;
	private String jobTitle;
	private String jobLocation;
	private String jobCategory;
	private String jobDescription;
	private List<String> rolesAndResponsibilities;
	private String jobStartDate;
	private String jobEndDate;
	private String jobRate;
	private String jobType;
	private List<String> skill;
	private String educationQualifications;
	private String experienceLevel;
	private boolean  mcq;
	private boolean codingTest;
	private boolean video;
	private boolean customQuestion;
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientHiringManager() {
		return clientHiringManager;
	}
	public void setClientHiringManager(String clientHiringManager) {
		this.clientHiringManager = clientHiringManager;
	}
	public String getClientProjectManager() {
		return clientProjectManager;
	}
	public void setClientProjectManager(String clientProjectManager) {
		this.clientProjectManager = clientProjectManager;
	}
	public String getClientProjectDescription() {
		return clientProjectDescription;
	}
	public void setClientProjectDescription(String clientProjectDescription) {
		this.clientProjectDescription = clientProjectDescription;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public String getJobCategory() {
		return jobCategory;
	}
	public void setJobCategory(String jobCategory) {
		this.jobCategory = jobCategory;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	
	public String getJobStartDate() {
		return jobStartDate;
	}
	public void setJobStartDate(String jobStartDate) {
		this.jobStartDate = jobStartDate;
	}
	public String getJobEndDate() {
		return jobEndDate;
	}
	public void setJobEndDate(String jobEndDate) {
		this.jobEndDate = jobEndDate;
	}
	public String getJobRate() {
		return jobRate;
	}
	public void setJobRate(String jobRate) {
		this.jobRate = jobRate;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	
	public String getEducationQualifications() {
		return educationQualifications;
	}
	public void setEducationQualifications(String educationQualifications) {
		this.educationQualifications = educationQualifications;
	}
	public String getExperienceLevel() {
		return experienceLevel;
	}
	public void setExperienceLevel(String experienceLevel) {
		this.experienceLevel = experienceLevel;
	}
	
	
	public String getRequisitionId() {
		return requisitionId;
	}
	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}
	public List<String> getRolesAndResponsibilities() {
		return rolesAndResponsibilities;
	}
	public void setRolesAndResponsibilities(List<String> rolesAndResponsibilities) {
		this.rolesAndResponsibilities = rolesAndResponsibilities;
	}
	public List<String> getSkill() {
		return skill;
	}
	public void setSkill(List<String> skill) {
		this.skill = skill;
	}
	public boolean isMcq() {
		return mcq;
	}
	public void setMcq(boolean mcq) {
		this.mcq = mcq;
	}
	public boolean isCodingTest() {
		return codingTest;
	}
	public void setCodingTest(boolean codingTest) {
		this.codingTest = codingTest;
	}
	public boolean isVideo() {
		return video;
	}
	public void setVideo(boolean video) {
		this.video = video;
	}
	public boolean isCustomQuestion() {
		return customQuestion;
	}
	public void setCustomQuestion(boolean customQuestion) {
		this.customQuestion = customQuestion;
	}
	
	

	


}
