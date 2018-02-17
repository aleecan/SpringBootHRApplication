package com.alican.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "job_applicant")
public class JobApplicant {
    @Id
    @Column(name = "applicant_id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private int id;
    @Column(name = "job_id")
    private int jobId;

    @Column(name = "user_id")
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
