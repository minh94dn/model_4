package com.example.demo_bai_thi.dto;

import com.example.demo_bai_thi.model.HinhThucHanhToan;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


public class NguoiThueDto {
    private int id;
    @NotBlank(message = "không đươc để trống")
    @Pattern(regexp = "[a-zA-z ]+", message = "Tên không được nhập số và ký tự đặc biệt.")
    private String name;
    @NotBlank(message = "không đươc để trống")
    @Pattern(regexp = "^((0|[(]84[)][+])9[01]\\d{7})| *$",
            message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx.")
    private String phoneNumber;
    @NotBlank(message = "không đươc để trống")
    @Pattern(regexp = "^(19|20)\\d{2}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[0-1])$",
            message = "Ngày sinh phải đúng định dạng DD/MM/YYYY.")
    private String startDay;
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
