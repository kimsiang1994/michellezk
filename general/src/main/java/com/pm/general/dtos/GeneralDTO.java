package com.pm.general.dtos;

import com.pm.general.entity.EmployeeEntity;
import com.pm.general.entity.SiteEntity;
import com.pm.general.entity.SparePartEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeneralDTO {

    private List<EmployeeEntity> employees;
    private List<SparePartEntity> spareParts;
    private List<SiteEntity> sites;
}
