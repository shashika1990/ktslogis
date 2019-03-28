package com.ktslogis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContainerSize {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String containerSize;


    public ContainerSize() {
    }

    public ContainerSize(String containerSize) {
        this.containerSize = containerSize;
    }

    public String getContainerSize() {
        return containerSize;
    }

    public void setContainerSize(String containerSize) {
        this.containerSize = containerSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ContainerSize{" +
                "id=" + id +
                ", containerSize=" + containerSize +
                '}';
    }
}
