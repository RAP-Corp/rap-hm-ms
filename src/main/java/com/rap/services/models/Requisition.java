package com.rap.services.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Requisition {
	
	@Id
	private String documentId;
	private String insertedBy;
	private long insertDate;
	private String updatedBy;
	private long updateDate;
	private String clientName;
	private String clientHiringManager;
	private String clientProjectManager;
	private String clientProjectDescription;
	private String jobTitle;
	private String jobLocation;
	private String jobCategory;
	private String jobDescription;
	private String rolesAndResponsibilities;
	private String jobStartDate;
	private String jobEndDate;
	private String jobRate;
	private String jobType;
	private String skill;
	private String educationQualifications;
	private String experienceLevel;
	private String MCQ;
	private String CodingTest;
	private String Video;
	private String customQuestion;
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
	public String getRolesAndResponsibilities() {
		return rolesAndResponsibilities;
	}
	public void setRolesAndResponsibilities(String rolesAndResponsibilities) {
		this.rolesAndResponsibilities = rolesAndResponsibilities;
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
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
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
	public String getMCQ() {
		return MCQ;
	}
	public void setMCQ(String mCQ) {
		MCQ = mCQ;
	}
	public String getCodingTest() {
		return CodingTest;
	}
	public void setCodingTest(String codingTest) {
		CodingTest = codingTest;
	}
	public String getVideo() {
		return Video;
	}
	public void setVideo(String video) {
		Video = video;
	}
	public String getCustomQuestion() {
		return customQuestion;
	}
	public void setCustomQuestion(String customQuestion) {
		this.customQuestion = customQuestion;
	}
	public String getInsertedBy() {
		return insertedBy;
	}
	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public long getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(long insertDate) {
		this.insertDate = insertDate;
	}
	public long getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(long updateDate) {
		this.updateDate = updateDate;
	}


}
