package com.example.apex.holdings.nusaiba.task.one.repository;

import com.example.apex.holdings.nusaiba.task.one.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    //Get all employee matching dept_id
    List<Employee> findByDepartmentDeptId(Long deptId);
}
