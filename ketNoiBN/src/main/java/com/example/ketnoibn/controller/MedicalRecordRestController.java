package com.example.ketnoibn.controller;

import com.example.ketnoibn.dto.MedicalRecordDto;
import com.example.ketnoibn.model.MedicalRecord;
import com.example.ketnoibn.service.IMedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/benhAns")
@CrossOrigin("*")
public class MedicalRecordRestController {
    @Autowired
    private IMedicalRecordService iMedicalRecordService;

    @GetMapping("")
    public ResponseEntity<Page<MedicalRecord>> showList(@PageableDefault(size = 2) Pageable pageable) {
        Page<MedicalRecord> medicalRecordPage = iMedicalRecordService.showList(pageable);
        if (medicalRecordPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(medicalRecordPage, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        iMedicalRecordService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("add")
    public ResponseEntity<?> create(@Validated @RequestBody MedicalRecordDto medicalRecordDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(bindingResult.getAllErrors() ,HttpStatus.BAD_REQUEST);
        }
        iMedicalRecordService.add(medicalRecordDto.getCode(), medicalRecordDto.getCodePatient(), medicalRecordDto.getNamePatient(), medicalRecordDto.getStartDate(), medicalRecordDto.getEndDate(), medicalRecordDto.getReason(), medicalRecordDto.getTreatments(), medicalRecordDto.getNameDoctors());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicalRecord> findById(@PathVariable int id){
         MedicalRecord medicalRecord = iMedicalRecordService.findById(id);
         if(medicalRecord == null){
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
         }
        return new ResponseEntity<>(medicalRecord, HttpStatus.OK);
    }

    @PutMapping("edit")
    public ResponseEntity<?> edit(@RequestBody MedicalRecord medicalRecord) {
        iMedicalRecordService.edit(medicalRecord.getCode(), medicalRecord.getCodePatient(), medicalRecord.getNamePatient(), medicalRecord.getStartDate(), medicalRecord.getEndDate(), medicalRecord.getReason(), medicalRecord.getTreatments(), medicalRecord.getNameDoctors(), medicalRecord.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
