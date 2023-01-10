package com.example.demo_bai_thi.service.impl;

import com.example.demo_bai_thi.model.HinhThucHanhToan;
import com.example.demo_bai_thi.repository.IHinhThucThanhToanRepository;
import com.example.demo_bai_thi.service.IHinhThucThanhToanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HinhThucThanhToanService implements IHinhThucThanhToanService {
    @Autowired
    private IHinhThucThanhToanRepository iHinhThucThanhToanRepository;

    @Override
    public List<HinhThucHanhToan> findAll() {
        return iHinhThucThanhToanRepository.findAll();
    }
}
