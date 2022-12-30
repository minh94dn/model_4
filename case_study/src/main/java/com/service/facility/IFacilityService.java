package com.service.facility;

import com.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IFacilityService {
    Page<Facility> findByNameAndFacilityType(String name, String facilityTypeName, Pageable pageable);

    List<Facility> findAll();

    boolean add(Facility facility);

    boolean edit(Facility facility);

    void deleteById(int id);

    Optional<Facility> findById(int id);
}
