package com.example.ketnoibn.repository;

import com.example.ketnoibn.model.MedicalRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IMedicalRecordRepository extends JpaRepository<MedicalRecord, Integer> {
    @Query(value = "select * from medical_record", nativeQuery = true)
    Page<MedicalRecord> showList(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value = "delete from medical_record where id = :id", nativeQuery = true)
    void deleteById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "insert into medical_record(code, code_patient, name_patient, start_date, end_date, reason, treatments, name_doctors) value(:code, :codePatient, :namePatient, :startDate, :endDate, :reason, :treatments, :nameDoctors)", nativeQuery = true)
    void add(@Param("code") String code, @Param("codePatient") String codePatient, @Param("namePatient") String namePatient, @Param("startDate") String startDate, @Param("endDate") String endDate, @Param("reason") String reason, @Param("treatments") String treatments, @Param("nameDoctors") String nameDoctors);

    @Transactional
    @Query(value = "select * from medical_record where id = :id", nativeQuery = true)
    MedicalRecord findById(@Param("id") int id);

    @Transactional
    @Modifying
    @Query(value = "update medical_record set code = :code, code_patient = :codePatient, name_patient = :namePatient, start_date = :startDate, end_date = :endDate, reason = :reason, treatments = :treatments, name_doctors = :nameDoctors where id = :id", nativeQuery = true)
    void edit(@Param("code") String code, @Param("codePatient") String codePatient, @Param("namePatient") String namePatient, @Param("startDate") String startDate, @Param("endDate") String endDate, @Param("reason") String reason, @Param("treatments") String treatments, @Param("nameDoctors") String nameDoctors, @Param("id") int id);
}
