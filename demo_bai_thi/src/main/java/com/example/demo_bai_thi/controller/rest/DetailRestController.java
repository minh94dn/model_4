package com.example.demo_bai_thi.controller.rest;

import com.example.demo_bai_thi.dto.IDetailDto;
import com.example.demo_bai_thi.service.INguoiThueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-detail")
@CrossOrigin("*")
public class DetailRestController {
    @Autowired
    private INguoiThueService iNguoiThueService;

    @GetMapping("/showDetail/{id}")
    public ResponseEntity<List<IDetailDto>> getList(@PathVariable("id") int id) {
        List<IDetailDto> iDetailDtoList = iNguoiThueService.showDetail(id);
        if (iDetailDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iDetailDtoList, HttpStatus.OK);
    }
}
