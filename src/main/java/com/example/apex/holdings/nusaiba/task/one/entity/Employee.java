package com.example.apex.holdings.nusaiba.task.one.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "EMPLOYEE")
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


    @NonNull
    @Column(name = "NAME")
    private String name;


    @NonNull
    @ManyToOne
    @JoinColumn(name = "DEPT_ID", referencedColumnName ="DEPT_ID")
    private Department department;


    @NonNull
    @Column(name = "DESIGNATION")
    private String designation;


    @Column(name = "SALARY")
    private Double salary;


    @Column(name = "BIRTH_DATE")
    private LocalDate birthDate;


    @Column(name = "JOIN_DATE")
    private LocalDate joinDate;


    @Column(name = "STATUS")
    private String status;


    @Column(name = "CREATED_DATE")
    private LocalDate createdDate;


    @Column(name = "UPDATE_DATE")
    private LocalDate updateDate;
}
