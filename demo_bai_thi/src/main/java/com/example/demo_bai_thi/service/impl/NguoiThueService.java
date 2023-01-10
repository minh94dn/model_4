package com.example.demo_bai_thi.service.impl;

import com.example.demo_bai_thi.dto.IDetailDto;
import com.example.demo_bai_thi.model.NguoiThue;
import com.example.demo_bai_thi.repository.INguoiThueRepository;
import com.example.demo_bai_thi.service.INguoiThueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NguoiThueService implements INguoiThueService {
    @Autowired
    private INguoiThueRepository iNguoiThueRepository;

    @Override
    public Page<NguoiThue> findByNameAndPhoneNumber(String name, String phoneNumber, Pageable pageable) {
        return iNguoiThueRepository.findByNameAndPhoneNumber(name, phoneNumber, pageable);
    }

    @Override
    public void delete(int id) {
        iNguoiThueRepository.deleteById(id);
    }

    @Override
    public void add(NguoiThue nguoiThue) {
        iNguoiThueRepository.save(nguoiThue);
    }

    @Override
    public List<IDetailDto> showDetail(int id) {
        return iNguoiThueRepository.showDetail(id);
    }

//    @Override
//    public void deleteByCheckBox(String deleteId) {
//        iNguoiThueRepository.deleteByCheckBox(deleteId);
//    }
}
