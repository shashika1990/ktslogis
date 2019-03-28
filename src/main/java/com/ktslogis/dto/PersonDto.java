package com.ktslogis.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class PersonDto {

    private int id;
    private String name;

    //1 means active, 0 means inactive
    @Min(value = 0)
    @Max(value = 1)
    private int empStatus;

    private JobRoleDto jobRole;

    public PersonDto() {
    }

    public PersonDto(int id, String name, JobRoleDto jobRole) {
        this.id = id;
        this.name = name;
        this.jobRole = jobRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JobRoleDto getJobRole() {
        return jobRole;
    }

    public void setJobRole(JobRoleDto jobRole) {
        this.jobRole = jobRole;
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jobRole=" + jobRole +
                '}';
    }
}
