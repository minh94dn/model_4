package com.example.demo_bai_thi.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class HinhThucHanhToan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(mappedBy = "hinhThucHanhToan")
    private Set<NguoiThue> nguoiThues;

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

    public Set<NguoiThue> getNguoiThues() {
        return nguoiThues;
    }

    public void setNguoiThues(Set<NguoiThue> nguoiThues) {
        this.nguoiThues = nguoiThues;
    }
}
