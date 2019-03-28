package com.ktslogis.dto;

public class ContainerDto {

    private int id;
    private String containerNo;
    private ContainerSizeDto containerSize;

    public ContainerDto() {
    }

    public ContainerDto(int id, String containerNo, String containerSize) {
        this.id = id;
        this.containerNo = containerNo;
    }

    public ContainerDto(int id, String containerNo, ContainerSizeDto containerSize) {
        this.id = id;
        this.containerNo = containerNo;
        this.containerSize = containerSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContainerNo() {
        return containerNo;
    }

    public void setContainerNo(String containerNo) {

        this.containerNo = containerNo.toUpperCase();
    }

    public ContainerSizeDto getContainerSize() {
        return containerSize;
    }

    public void setContainerSize(ContainerSizeDto containerSize) {
        this.containerSize = containerSize;
    }

    @Override
    public String toString() {
        return "ContainerDto{" +
                "id=" + id +
                ", containerNo='" + containerNo + '\'' +
                ", containerSize=" + containerSize +
                '}';
    }
}
