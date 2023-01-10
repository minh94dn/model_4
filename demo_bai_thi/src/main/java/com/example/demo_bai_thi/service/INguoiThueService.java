package com.example.demo_bai_thi.service;

import com.example.demo_bai_thi.dto.IDetailDto;
import com.example.demo_bai_thi.model.NguoiThue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INguoiThueService {
    Page<NguoiThue> findByNameAndPhoneNumber(String name, String phoneNumber, Pageable pageable);

    void delete(int id);

    void add(NguoiThue nguoiThue);

//    void deleteByCheckBox(String deleteId);

    List<IDetailDto> showDetail(int id);
}
