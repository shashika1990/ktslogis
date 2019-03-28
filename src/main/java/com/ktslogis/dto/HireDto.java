package com.ktslogis.dto;

import java.util.Date;
import java.util.List;

public class HireDto {

    private int id;

    private ContainerDto container;

    private Date date;

    private PersonDto driver;

    private PersonDto mate;

    private VehicleDto vehicle;

    private List<HireRemarkDto> remark;

    //no arg constructor
    public HireDto() {
    }

    //constructor
    public HireDto(int id, ContainerDto container, Date date, PersonDto driver, PersonDto mate, VehicleDto vehicle, List<HireRemarkDto> remark) {
        this.id = id;
        this.container = container;
        this.date = date;
        this.driver = driver;
        this.mate = mate;
        this.vehicle = vehicle;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContainerDto getContainer() {
        return container;
    }

    public void setContainer(ContainerDto container) {
        this.container = container;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public PersonDto getDriver() {
        return driver;
    }

    public void setDriver(PersonDto driver) {
        this.driver = driver;
    }

    public PersonDto getMate() {
        return mate;
    }

    public void setMate(PersonDto mate) {
        this.mate = mate;
    }

    public VehicleDto getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDto vehicle) {
        this.vehicle = vehicle;
    }

    public List<HireRemarkDto> getRemark() {
        return remark;
    }

    public void setRemark(List<HireRemarkDto> remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "HireDto{" +
                "id=" + id +
                ", container=" + container +
                ", date=" + date +
                ", driver=" + driver +
                ", mate=" + mate +
                ", vehicle=" + vehicle +
                ", remark=" + remark +
                '}';
    }
}
