package com.example.ketnoibn.service;

import com.example.ketnoibn.model.MedicalRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMedicalRecordService {
    Page<MedicalRecord> showList(Pageable pageable);

    void deleteById(int id);

    void add(String code, String codePatient, String namePatient, String startDate, String endDate, String reason, String treatments, String nameDoctors);

    MedicalRecord findById(int id);

    void edit(String code, String codePatient, String namePatient, String startDate, String endDate, String reason, String treatments, String nameDoctors, int id);
}
