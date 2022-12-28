package com.repository.facility;

import com.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Query(value = "select f.* from `facility` f join `facility_type` ft on f.facility_type_id = ft.id join rent_type rt on f.rent_type_id = rt.id where f.name like %:name% and ft.name like %:facilityType%", nativeQuery = true)
    Page<Facility> findByNameAndFacilityType(@Param("name") String name, @Param("facilityType") String facilityType, Pageable pageable);
}
