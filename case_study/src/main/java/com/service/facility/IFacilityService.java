package com.service.facility;

import com.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IFacilityService {
    Page<Facility> findByNameAndFacilityType(String name, String facilityTypeName, Pageable pageable);

    void add(Facility facility);

    void edit(Facility facility);

    void deleteById(int id);

    Optional<Facility> findById(int id);
}
