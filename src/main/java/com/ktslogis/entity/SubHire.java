package com.ktslogis.entity;

import javax.persistence.*;

@Entity
public class SubHire {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToOne
    private Hire mainHire;

    @OneToOne
    private Hire subHire;

    public SubHire() {
    }

    public SubHire(Hire mainHire, Hire subHire) {
        this.mainHire = mainHire;
        this.subHire = subHire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hire getMainHire() {
        return mainHire;
    }

    public void setMainHire(Hire mainHire) {
        this.mainHire = mainHire;
    }

    public Hire getSubHire() {
        return subHire;
    }

    public void setSubHire(Hire subHire) {
        this.subHire = subHire;
    }

    @Override
    public String toString() {
        return "SubHire{" +
                "id=" + id +
                ", mainHire=" + mainHire +
                ", subHire=" + subHire +
                '}';
    }
}
