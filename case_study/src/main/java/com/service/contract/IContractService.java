package com.service.contract;

import com.dto.IAttachFacilityDto;
import com.dto.IContractDto;
import com.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    void add(Contract contract);

    Page<IContractDto> listContract(Pageable pageable);

    List<IAttachFacilityDto> listAttachFacility(int id);
}
