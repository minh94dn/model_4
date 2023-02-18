package com.example.ketnoibn.repository;

import com.example.ketnoibn.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IMedicalRecordRepository extends JpaRepository<MedicalRecord, Integer> {
    @Query(value = "select * from medical_record", nativeQuery = true)
    List<MedicalRecord> showList();

    @Transactional
    @Modifying
    @Query(value = "delete from medical_record where id = :id", nativeQuery = true)
    void deleteById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "insert into medical_record(code, code_patient, name_patient, start_date, end_date, reason, treatments, name_doctors) value(:code, :codePatient, namePatient, :startDate, :endDate, :reason, :treatments, :nameDoctors)", nativeQuery = true)
    void add(@Param("code") String code, @Param("codePatient") String codePatient, @Param("namePatient") String namePatient, @Param("startDate") String startDate, @Param("endDate") String endDate, @Param("reason") String reason, @Param("treatments") String treatments, @Param("nameDoctors") String nameDoctors);
}
