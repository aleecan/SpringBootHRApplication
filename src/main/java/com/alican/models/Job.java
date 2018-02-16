package com.alican.models;

import javax.persistence.*;

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
}
