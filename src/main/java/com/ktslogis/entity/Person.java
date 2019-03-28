package com.ktslogis.entity;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "jobRoleId")
    private JobRole jobRole;


    private int empStatus;


    public Person() {
    }

    public Person(String name, JobRole jobRole, int empStatus) {
        this.name = name;
        this.jobRole = jobRole;
        this.empStatus = empStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JobRole getJobRole() {
        return jobRole;
    }

    public void setJobRole(JobRole jobRole) {
        this.jobRole = jobRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(int empStatus) {
        this.empStatus = empStatus;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job_role=" + jobRole +
                ", empStatus=" + empStatus +
                '}';
    }
}
