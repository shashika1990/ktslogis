package com.ktslogis.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String vehicleNo;

    //1 means active, 0 means inactive
    private int vehicleStatus;

    public Vehicle() {
    }

    public Vehicle(String vehicleNo, int vehicleStatus) {
        this.vehicleNo = vehicleNo;
        this.vehicleStatus = vehicleStatus;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public int isVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(int vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", vehicleNo='" + vehicleNo + '\'' +
                ", vehicleStatus=" + vehicleStatus +
                '}';
    }
}
