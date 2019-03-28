package com.ktslogis.dto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class VehicleDto {
    private int id;

    private String vehicleNo;

    //1 means active, 0 means inactive
    @Min(value = 0)
    @Max(value = 1)
    private int vehicleStatus;

    public VehicleDto() {
    }

    public VehicleDto(int id, String vehicleNo, int vehicleStatus) {
        this.id = id;
        this.vehicleNo = vehicleNo;
        this.vehicleStatus = vehicleStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public int getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(int vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    @Override
    public String toString() {
        return "VehicleDto{" +
                "id=" + id +
                ", vehicleNo='" + vehicleNo + '\'' +
                ", vehicleStatus=" + vehicleStatus +
                '}';
    }
}
