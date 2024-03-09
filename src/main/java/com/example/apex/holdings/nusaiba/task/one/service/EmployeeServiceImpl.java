package com.example.apex.holdings.nusaiba.task.one.service;

import com.example.apex.holdings.nusaiba.task.one.entity.Employee;
import com.example.apex.holdings.nusaiba.task.one.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentService departmentService;
    @Override
    public Employee insertEmployee(Employee employee) {
        //set created date
        employee.setCreatedDate(LocalDate.now());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getAllEmployeeByDepartmentId(Long id) throws RuntimeException {
        //Get all employee matching dept_id
        return employeeRepository.findByDepartmentDeptId(id);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) throws RuntimeException {
        //throw exception if employee not found
        Employee employeeToBeUpdated = employeeRepository.findById(id).orElseThrow(RuntimeException::new);

        employeeToBeUpdated.setName(employee.getName());
        employeeToBeUpdated.setDepartment(employee.getDepartment());
        employeeToBeUpdated.setDesignation(employee.getDesignation());
        employeeToBeUpdated.setSalary(employee.getSalary());
        employeeToBeUpdated.setJoinDate(employee.getJoinDate());
        employeeToBeUpdated.setBirthDate(employee.getBirthDate());
        employeeToBeUpdated.setStatus(employee.getStatus());
        //set updated date
        employeeToBeUpdated.setUpdateDate(LocalDate.now());
        return employeeRepository.save(employeeToBeUpdated);
    }

    @Override
    public void deleteEmployee(Long id) throws RuntimeException {
        //throw exception if employee not found
        Employee employeeToBeDeleted = employeeRepository.findById(id).orElseThrow(RuntimeException::new);
        employeeRepository.delete(employeeToBeDeleted);
    }
}
