package com.example.apex.holdings.nusaiba.task.one.service;

import com.example.apex.holdings.nusaiba.task.one.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee insertEmployee(Employee employee);
    Employee getEmployee(Long id);
    List<Employee> getAllEmployee();
    List<Employee> getAllEmployeeByDepartmentId(Long id);

    Employee updateEmployee(Long id, Employee employee) throws RuntimeException;

    void deleteEmployee(Long id) throws RuntimeException;
}
