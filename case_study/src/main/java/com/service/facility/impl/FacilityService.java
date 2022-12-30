package com.service.facility.impl;

import com.model.facility.Facility;
import com.repository.facility.IFacilityRepository;
import com.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Page<Facility> findByNameAndFacilityType(String name, String facilityTypeName, Pageable pageable) {
        return iFacilityRepository.findByNameAndFacilityType(name, facilityTypeName, pageable);
    }

    @Override
    public List<Facility> findAll() {
        return iFacilityRepository.findAll();
    }


    @Override
    public boolean add(Facility facility) {
        for (int i = 0; i <findAll().size() ; i++) {
            if(facility.getName().equals(findAll().get(i).getName())){
             return false;
            }
        }
        iFacilityRepository.save(facility);
        return true;
    }

    @Override
    public boolean edit(Facility facility) {
        for (int i = 0; i <findAll().size() ; i++) {
            if(facility.getName().equals(findAll().get(i).getName())){
                return false;
            }
        }
        iFacilityRepository.save(facility);
        return true;
    }

    @Override
    public void deleteById(int id) {
        iFacilityRepository.deleteById(id);
    }

    @Override
    public Optional<Facility> findById(int id) {
        return iFacilityRepository.findById(id);
    }
}
