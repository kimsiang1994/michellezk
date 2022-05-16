package com.pm.general.manager.controller;

import com.pm.general.dtos.GeneralDTO;
import com.pm.general.service.GeneralService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RestController
@RequestMapping(value = "/pm/general/")
public class GeneralEntityController {

    @Autowired
    private GeneralService generalService;

    @GetMapping(value = "{entityType}")
    public GeneralDTO getEntityDetails(@PathVariable String entityType) {
        log.info("GeneralEntityController -> getEntityDetails");
        return generalService.getSpecificEntities(entityType);
    }

    @GetMapping(value = "{entityType}/{id}")
    public GeneralDTO getSingleEntity(@PathVariable String entityType, @PathVariable Long id) {
        return generalService.getSingleEntity(entityType, id);
    }

    @PostMapping(value = "{entityType}")
    public void saveOrEditEntity(@PathVariable String entityType, @RequestBody Object entity) {
        try {
            generalService.saveOrEditEntity(entityType, entity);
        } catch (HttpMessageNotReadableException exc) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Foo Not Found", exc);
        }
    }

    @DeleteMapping(value = "{entityType}/{id}")
    public void deleteEntity(@PathVariable String entityType, @PathVariable Long id) {
        generalService.deleteEntity(entityType, id);
    }

}
