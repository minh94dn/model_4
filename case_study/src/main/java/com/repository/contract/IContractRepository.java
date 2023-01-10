package com.repository.contract;

import com.dto.IAttachFacilityDto;
import com.dto.IContractDto;
import com.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    @Query(value = "select ctr.id, f.`name` as nameFacility, c.`name` as nameCustomer, ctr.start_date as startDate, ctr.end_date as endDate, ctr.deposit, ifnull(f.cost,0) + sum(ifnull(af.cost * cd.quantity,0)) as sumMoney from `customer` c join `contract` ctr on ctr.customer_id=c.id join `facility` f on f.id= ctr.facility_id left join `attach_facility` af on af.id=ctr.id left join `contract_detail` cd on cd.contract_id = ctr.id group by ctr.id, c.id order by ctr.id", nativeQuery = true)
    Page<IContractDto> listContract(Pageable pageable);

    @Query(value = "select contract.id, af.name, af.cost, af.unit, af.status, sum(cd.quantity) as sumQuantity, (af.cost * sum(cd.quantity)) as sumMoney from contract join contract_detail cd on contract.id = cd.contract_id join attach_facility af on af.id = cd.attach_facility_id where contract.id=:id group by af.id,contract.id;", nativeQuery = true)
    List<IAttachFacilityDto> listAttachFacility(@Param("id") int id);
}
