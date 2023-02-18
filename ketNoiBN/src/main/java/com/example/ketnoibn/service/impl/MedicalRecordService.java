package com.example.ketnoibn.service.impl;

import com.example.ketnoibn.model.MedicalRecord;
import com.example.ketnoibn.repository.IMedicalRecordRepository;
import com.example.ketnoibn.service.IMedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class MedicalRecordService implements IMedicalRecordService {
    @Autowired
    private IMedicalRecordRepository iMedicalRecordRepository;


    @Override
    public Page<MedicalRecord> showList(Pageable pageable) {
        return iMedicalRecordRepository.showList(pageable);
    }

    @Override
    public void deleteById(int id) {
        iMedicalRecordRepository.deleteById(id);
    }

    @Override
    public void add(String code, String codePatient, String namePatient, String startDate, String endDate, String reason, String treatments, String nameDoctors) {
        iMedicalRecordRepository.add(code, codePatient, namePatient, startDate, endDate, reason, treatments, nameDoctors);
    }

    @Override
    public MedicalRecord findById(int id) {
        return iMedicalRecordRepository.findById(id);
    }

    @Override
    public void edit(String code, String codePatient, String namePatient, String startDate, String endDate, String reason, String treatments, String nameDoctors, int id) {
        iMedicalRecordRepository.edit(code, codePatient, namePatient, startDate, endDate, reason, treatments, nameDoctors, id);
    }
}
