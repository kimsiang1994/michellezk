package com.pm.general.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_Employee")
@Builder
public class EmployeeEntity implements Serializable {

    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long employeeUniqueId;
    private String employeeId;
    private String firstName;
    private String lastName;
    private String superiorId;
    private String emailAddress;
    private Long mobileNumber;
    private String title;
    private String rank;

    @OneToMany
    private List<SiteEntity> sites;

}
