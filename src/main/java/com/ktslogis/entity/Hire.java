package com.ktslogis.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Hire {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "containerId", nullable = false)
    private Container container;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date date;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "driverPersonId")
    private Person driver;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "matePersonId")
    private Person mate;

    @ManyToOne
    @JoinColumn(name = "vehicleId", nullable = false)
    private Vehicle vehicle;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "hire")
    private List<HireRemark> remark;

    @OneToOne
    @JoinColumn
    private Hire mainHire;

    public Hire() {
    }

    public Hire(Container container, Date date, Person driver, Person mate, Vehicle vehicle, List<HireRemark> remark) {
        this.container = container;
        this.date = date;
        this.driver = driver;
        this.mate = mate;
        this.vehicle = vehicle;
        this.remark = remark;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Person getDriver() {
        return driver;
    }

    public void setDriver(Person driver) {
        this.driver = driver;
    }

    public Person getMate() {
        return mate;
    }

    public void setMate(Person mate) {
        this.mate = mate;
    }


    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public List<HireRemark> getRemarks() {
        return remark;
    }

    public void setRemarks(List<HireRemark> remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Hire{" +
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
