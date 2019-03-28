package com.ktslogis.dto;

public class HireRemarkDto {

    private int id;

    private String remark;

    private HireDto hire;

    public HireRemarkDto() {
    }

    public HireRemarkDto(int id, String remark, HireDto hire) {
        this.id = id;
        this.remark = remark;
        this.hire = hire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HireDto getHire() {
        return hire;
    }

    public void setHire(HireDto hire) {
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
        return "HireRemarkDto{" +
                "id=" + id +
                ", remark='" + remark + '\'' +
                ", hire=" + hire +
                '}';
    }
}
