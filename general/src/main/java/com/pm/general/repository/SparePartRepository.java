package com.pm.general.repository;

import com.pm.general.entity.SparePartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SparePartRepository extends JpaRepository<SparePartEntity, Long> {

    SparePartEntity findByUniqueId(Long id);
}
