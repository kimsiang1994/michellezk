package com.pm.general.manager;

import com.pm.general.entity.SparePartEntity;
import com.pm.general.repository.SparePartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SparePartManager {

    @Autowired
    private SparePartRepository sparePartRepository;

    public List<SparePartEntity> getAllSpareParts(){
        return sparePartRepository.findAll();
    }

    public SparePartEntity getSparePartById(Long id){
        return sparePartRepository.findByUniqueId(id);
    }

    public void saveSparePart(SparePartEntity sparePartEntity){
        sparePartRepository.save(sparePartEntity);
    }

    public void deleteSparePartById(Long id){
        sparePartRepository.deleteById(id);
    }
}
