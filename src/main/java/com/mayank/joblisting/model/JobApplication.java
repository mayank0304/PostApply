package com.mayank.joblisting.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "applicants")
public class JobApplication {
    private String job_profile;
    private String applicantName;
    private String applicantEmail;
    private String resumeLink;
    public JobApplication(String job_id, String applicantName, String applicantEmail, String resumeLink) {
        this.job_profile = job_id;
        this.applicantName = applicantName;
        this.applicantEmail = applicantEmail;
        this.resumeLink = resumeLink;
    }
    public JobApplication() {
    }
    public String getJob_profile() {
        return job_profile;
    }
    public void setJob_profile(String job_id) {
        this.job_profile = job_id;
    }
    public String getApplicantName() {
        return applicantName;
    }
    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }
    public String getApplicantEmail() {
        return applicantEmail;
    }
    public void setApplicantEmail(String applicantEmail) {
        this.applicantEmail = applicantEmail;
    }
    public String getResumeLink() {
        return resumeLink;
    }
    public void setResumeLink(String resumeLink) {
        this.resumeLink = resumeLink;
    }
}
