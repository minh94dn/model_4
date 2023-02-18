package com.example.ketnoibn.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class MedicalRecordDto {
    private int id;
    @NotBlank
    @Pattern(message = "Mã bênh án không đúng định dạnh BA-xxx", regexp = "BA-[\\d]+")
    private String code;

//    @NotBlank
//    @Pattern(message = "Mã bênh nhân không đúng định dạnh BN-xxx", regexp = "BN-[\\d]+")
    private String codePatient;

//    @NotBlank(message = "Không được để trống")
//    @Pattern(message = "Tên không được chứa ký tự số", regexp = "\\D{1,}")
    private String namePatient;

//    @NotBlank(message = "Không được để trống")
    private String startDate;

//    @NotBlank(message = "Không được để trống")
    private String endDate;

//    @NotBlank(message = "Không được để trống")
    private String reason;

//    @NotBlank(message = "Không được để trống")
    private String treatments;

    @NotBlank(message = "Không được để trống")
    private String nameDoctors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodePatient() {
        return codePatient;
    }

    public void setCodePatient(String codePatient) {
        this.codePatient = codePatient;
    }

    public String getNamePatient() {
        return namePatient;
    }

    public void setNamePatient(String namePatient) {
        this.namePatient = namePatient;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTreatments() {
        return treatments;
    }

    public void setTreatments(String treatments) {
        this.treatments = treatments;
    }

    public String getNameDoctors() {
        return nameDoctors;
    }

    public void setNameDoctors(String nameDoctors) {
        this.nameDoctors = nameDoctors;
    }
}
