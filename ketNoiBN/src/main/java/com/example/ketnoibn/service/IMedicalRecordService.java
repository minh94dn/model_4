package com.example.ketnoibn.service;

import com.example.ketnoibn.model.MedicalRecord;

import java.util.List;

public interface IMedicalRecordService {
    List<MedicalRecord> showList();

    void deleteById(int id);

    void add(String code, String codePatient, String namePatient, String startDate, String endDate, String reason, String treatments, String nameDoctors);
}
