package com.controller.rest;

import com.dto.IAttachFacilityDto;
import com.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api-attachFacility")
@CrossOrigin("*")
public class AttachFacilityRestController {
    @Autowired
    private IContractService iContractService;

    @GetMapping("/showListAttachFacility/{id}")
    public ResponseEntity<List<IAttachFacilityDto>> getList(
            @PathVariable("id") int id) {
        List<IAttachFacilityDto> attachFacilityDtoList = iContractService.listAttachFacility(id);
        if (attachFacilityDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(attachFacilityDtoList, HttpStatus.OK);
    }
}
