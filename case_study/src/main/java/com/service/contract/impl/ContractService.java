package com.service.contract.impl;

import com.dto.IAttachFacilityDto;
import com.dto.IContractDto;
import com.model.contract.Contract;
import com.repository.contract.IContractRepository;
import com.service.contract.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }

    @Override
    public void add(Contract contract) {
        iContractRepository.save(contract);
    }

    @Override
    public Page<IContractDto> listContract(Pageable pageable) {
        return iContractRepository.listContract(pageable);
    }

    @Override
    public List<IAttachFacilityDto> listAttachFacility(int id) {
        return iContractRepository.listAttachFacility(id);
    }
}
