package com.alican.models;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "job_id")
    private int id;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "job_description")
    private String jobDescription;
    @Column(name = "num_of_hire")
    private int numOfHire;
    @Column(name = "last_app_date")
    private long lastAppDateToMiliSecond;
    @Column(name = "is_active")
    private int isActive;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "join_job_applicant", joinColumns = @JoinColumn(name = "job_id"), inverseJoinColumns = @JoinColumn(name = "applicant_id"))
    private Set<Applicant> applicants;

    public Set<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(Set<Applicant> applicants) {
        this.applicants = applicants;
    }

    public long getLastAppDateToMiliSecond() {
        return lastAppDateToMiliSecond;
    }

    public void setLastAppDateToMiliSecond(long lastAppDateToMiliSecond) {
        this.lastAppDateToMiliSecond = lastAppDateToMiliSecond;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public int getNumOfHire() {
        return numOfHire;
    }

    public void setNumOfHire(int numOfHire) {
        this.numOfHire = numOfHire;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", numOfHire=" + numOfHire +
                ", lastAppDateToMiliSecond=" + lastAppDateToMiliSecond +
                ", isActive=" + isActive +
                ", applicants=" + applicants +
                '}';
    }
}
