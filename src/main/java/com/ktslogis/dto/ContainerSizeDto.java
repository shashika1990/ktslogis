package com.ktslogis.dto;

public class ContainerSizeDto {

    private int id;
    private String containerSize;

    public ContainerSizeDto() {
    }

    public ContainerSizeDto(int id, String containerSize) {
        this.id = id;
        this.containerSize = containerSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContainerSize() {
        return containerSize;
    }

    public void setContainerSize(String containerSize) {
        this.containerSize = containerSize;
    }

    @Override
    public String toString() {
        return "ContainerSizeDto{" +
                "id=" + id +
                ", containerSize=" + containerSize +
                '}';
    }
}
