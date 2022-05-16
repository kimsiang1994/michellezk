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
@Table(name = "T_SpareParts")
@Builder
public class SparePartEntity {

    @Id
    @SequenceGenerator(
            name = "sparepart_sequence",
            sequenceName = "sparepart_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sparepart_sequence"
    )
    private Long uniqueId;
    private String partName;
    private String description;
    private Long quantity;
    private Double price;
    private Long priority;
    private Long sitesTagged;
}
