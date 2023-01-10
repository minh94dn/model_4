package com.example.demo_bai_thi.model;

import javax.persistence.*;

@Entity
public class NguoiThue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phoneNumber;
    private String startDay;
    @ManyToOne
    @JoinColumn(name = "hinh_thuc_thanh_toan_id", referencedColumnName = "id")
    private HinhThucHanhToan hinhThucHanhToan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public HinhThucHanhToan getHinhThucHanhToan() {
        return hinhThucHanhToan;
    }

    public void setHinhThucHanhToan(HinhThucHanhToan hinhThucHanhToan) {
        this.hinhThucHanhToan = hinhThucHanhToan;
    }
}
