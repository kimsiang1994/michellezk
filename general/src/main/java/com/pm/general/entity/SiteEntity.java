package com.pm.general.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_Site")
@Builder
public class SiteEntity {

    @Id
    @SequenceGenerator(
            name = "site_sequence",
            sequenceName = "site_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "site_sequence"
    )
    private Long uniqueId;
    private Long blockNumber;
    private String streetName;
    private String unitNumber;
    private String city;
    private String country;
    private String postalCode;
    private String status;
    private String remarks;
    private Long sparePartsTagged;
    private Long employeesTagged;
}
