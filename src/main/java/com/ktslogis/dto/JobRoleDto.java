package com.ktslogis.dto;

public class JobRoleDto {
    private int id;
    private String title;

    public JobRoleDto() {
    }

    public JobRoleDto(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "JobRoleDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
