package com.example.apex.holdings.nusaiba.task.one.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "DEPARTMENTS")
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPT_ID")
    private Long deptId;


    @NonNull
    @Column(name = "DEPT_NAME")
    private String deptName;


    @Column(name = "CREATE_DATE")
    private LocalDate createdDate;
}
