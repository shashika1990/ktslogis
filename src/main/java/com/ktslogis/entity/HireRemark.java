package com.ktslogis.entity;

import javax.persistence.*;

@Entity
public class HireRemark {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToOne
    @JoinColumn(name = "hireId", nullable = false)
    private Hire hire;

    @Column(nullable = false)
    private String remark;

    public HireRemark() {
    }

    public HireRemark(Hire hire, String remark) {
        this.hire = hire;
        this.remark = remark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hire getHire() {
        return hire;
    }

    public void setHire(Hire hire) {
        this.hire = hire;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "HireRemark{" +
                "id=" + id +
                ", hire=" + hire +
                ", remark='" + remark + '\'' +
                '}';
    }
}
