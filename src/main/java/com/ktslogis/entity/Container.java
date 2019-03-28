package com.ktslogis.entity;

import javax.persistence.*;

@Entity
public class Container {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String containerNo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "containerSizeId")
    private ContainerSize containerSize;

    public ContainerSize getContainerSize() {

        return containerSize;
    }

    public void setContainerSize(ContainerSize containerSize) {

        this.containerSize = containerSize;
    }

    public Container() {
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

        this.containerNo = containerNo;
    }

    @Override
    public String toString() {
        return "Container{" +
                "id='" + id + '\'' +
                ", containerNo='" + containerNo + '\'' +
                ", containerSize=" + containerSize +
                '}';
    }
}
