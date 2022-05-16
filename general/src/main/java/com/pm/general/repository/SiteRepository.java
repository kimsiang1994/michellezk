package com.pm.general.repository;

import com.pm.general.entity.SiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteRepository extends JpaRepository<SiteEntity, Long> {

    SiteEntity findByUniqueId(Long id);
}
