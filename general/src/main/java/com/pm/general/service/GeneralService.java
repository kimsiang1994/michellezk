package com.pm.general.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pm.general.constants.ApplicationConstants;
import com.pm.general.dtos.GeneralDTO;
import com.pm.general.entity.EmployeeEntity;
import com.pm.general.entity.SiteEntity;
import com.pm.general.entity.SparePartEntity;
import com.pm.general.manager.EmployeeManager;
import com.pm.general.manager.SiteManager;
import com.pm.general.manager.SparePartManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GeneralService {

    @Autowired
    private EmployeeManager employeeManager;

    @Autowired
    private SiteManager siteManager;

    @Autowired
    private SparePartManager sparePartManager;

    @Autowired
    private ObjectMapper objectMapper;

    public GeneralDTO getSpecificEntities(String entityType){
        switch (entityType) {
            case ApplicationConstants.EMPLOYEE:
                return GeneralDTO.builder().employees(employeeManager.getAllEmployees()).build();
            case ApplicationConstants.SITE:
                return GeneralDTO.builder().sites(siteManager.getAllSites()).build();
            case ApplicationConstants.SPARE_PARTS:
                return GeneralDTO.builder().spareParts(sparePartManager.getAllSpareParts()).build();
            default:
                log.info("Entity Not Found, returning empty DTO");
                return new GeneralDTO();
        }
    }

    public GeneralDTO getSingleEntity(String entityType, Long id){
        switch (entityType) {
            case ApplicationConstants.EMPLOYEE:
                return GeneralDTO.builder().employees(List.of(employeeManager.getEmployeeById(id))).build();
            case ApplicationConstants.SITE:
                return GeneralDTO.builder().sites(List.of(siteManager.getSiteById(id))).build();
            case ApplicationConstants.SPARE_PARTS:
                return GeneralDTO.builder().spareParts(List.of(sparePartManager.getSparePartById(id))).build();
            default:
                log.info("Entity Not Found, returning empty DTO");
                return new GeneralDTO();
        }
    }

    public void saveOrEditEntity(String entityType, Object entity){
        switch (entityType) {
            case ApplicationConstants.EMPLOYEE:
                EmployeeEntity employeeEntity = objectMapper.convertValue(entity, EmployeeEntity.class);
                employeeManager.saveEmployee(employeeEntity);
                break;
            case ApplicationConstants.SITE:
                SiteEntity siteEntity = objectMapper.convertValue(entity, SiteEntity.class);
                siteManager.saveSite(siteEntity);
                break;
            case ApplicationConstants.SPARE_PARTS:
                SparePartEntity sparePartEntity = objectMapper.convertValue(entity, SparePartEntity.class);
                sparePartManager.saveSparePart(sparePartEntity);
                break;
            default:
                log.info("Incorrect Entity");
                break;
        }
    }

    public void deleteEntity(String entityType, Long id){
        switch (entityType) {
            case ApplicationConstants.EMPLOYEE:
                employeeManager.deleteEmployeeById(id);
                break;
            case ApplicationConstants.SITE:
                siteManager.deleteSiteById(id);
                break;
            case ApplicationConstants.SPARE_PARTS:
                sparePartManager.deleteSparePartById(id);
                break;
            default:
                log.info("Incorrect Entity");
                break;
        }
    }
}
