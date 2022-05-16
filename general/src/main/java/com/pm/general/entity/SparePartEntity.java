package com.pm.general.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private Long sparePartUniqueId;
    private String partName;
    private String description;
    private Long quantity;
    private Double price;
    private Long priority;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "site_id")
    private SiteEntity site;
}
