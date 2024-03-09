package com.example.apex.holdings.nusaiba.task.one.service;

import com.example.apex.holdings.nusaiba.task.one.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department insertDepartment(Department department);
    Department getDepartment(Long id);
    List<Department> getAllDepartment();
    Department updateDepartment(Long id, Department department) throws RuntimeException;
    void deleteDepartment(Long id) throws RuntimeException;
}
