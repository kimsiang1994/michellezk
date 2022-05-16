package com.pm.general.manager;

import com.pm.general.entity.SiteEntity;
import com.pm.general.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SiteManager {

    @Autowired
    private SiteRepository siteRepository;

    public List<SiteEntity> getAllSites(){
        return siteRepository.findAll();
    }

    public SiteEntity getSiteById(Long id){
        return siteRepository.findByUniqueId(id);
    }

    public void saveSite (SiteEntity siteEntity){
        siteRepository.save(siteEntity);
    }

    public void deleteSiteById(Long id){
        siteRepository.deleteById(id);
    }
}
