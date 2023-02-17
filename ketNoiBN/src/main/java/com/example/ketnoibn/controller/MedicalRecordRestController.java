package com.example.ketnoibn.controller;

import com.example.ketnoibn.model.MedicalRecord;
import com.example.ketnoibn.service.IMedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/benhAns")
@CrossOrigin("*")
@Transactional
public class MedicalRecordRestController {
    @Autowired
    private IMedicalRecordService iMedicalRecordService;

    @GetMapping("")
    public ResponseEntity<List<MedicalRecord>> showList() {
        List<MedicalRecord> medicalRecordList = iMedicalRecordService.showList();
        if (medicalRecordList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicalRecordList, HttpStatus.OK);
    }
    @Modifying
    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        iMedicalRecordService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
