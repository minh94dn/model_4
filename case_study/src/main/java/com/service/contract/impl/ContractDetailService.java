package com.service.contract.impl;

import com.model.contract.ContractDetail;
import com.repository.contract.IContractDetailRepository;
import com.service.contract.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository iContractDetailRepository;
    @Override
    public void add(ContractDetail contractDetail) {
        iContractDetailRepository.save(contractDetail);
    }
}
