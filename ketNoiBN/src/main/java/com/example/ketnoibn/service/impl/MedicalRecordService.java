package com.example.ketnoibn.service.impl;

import com.example.ketnoibn.model.MedicalRecord;
import com.example.ketnoibn.repository.IMedicalRecordRepository;
import com.example.ketnoibn.service.IMedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService implements IMedicalRecordService {
    @Autowired
    private IMedicalRecordRepository iMedicalRecordRepository;

    @Override
    public List<MedicalRecord> showList() {
        return iMedicalRecordRepository.showList();
    }

    @Override
    public void deleteById(int id) {
        iMedicalRecordRepository.deleteById(id);
    }

    @Override
    public void add(String code, String codePatient, String namePatient, String startDate, String endDate, String reason, String treatments, String nameDoctors) {
        iMedicalRecordRepository.add(code, codePatient, namePatient, startDate, endDate, reason, treatments, nameDoctors);
    }
}
