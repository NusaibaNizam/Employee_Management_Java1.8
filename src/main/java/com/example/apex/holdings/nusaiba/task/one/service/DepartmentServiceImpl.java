package com.example.apex.holdings.nusaiba.task.one.service;

import com.example.apex.holdings.nusaiba.task.one.entity.Department;
import com.example.apex.holdings.nusaiba.task.one.repository.DepartmentRepository;
import com.example.apex.holdings.nusaiba.task.one.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentService{
    @Autowired
    DepartmentRepository departmentRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Department insertDepartment(Department department) {
        //set created date
        department.setCreatedDate(LocalDate.now());
        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartment(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Department> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public Department updateDepartment(Long id, Department department) throws RuntimeException {
        //throw exception if department not found
        Department departmentToBeUpdated = departmentRepository.findById(id).orElseThrow(RuntimeException::new);
        departmentToBeUpdated.setDeptName(department.getDeptName());
        return departmentRepository.save(departmentToBeUpdated);
    }

    @Override
    public void deleteDepartment(Long id) throws RuntimeException {
        //throw exception if department not found
        Department departmentToBeDeleted = departmentRepository.findById(id).orElseThrow(RuntimeException::new);
        if(employeeRepository.findByDepartmentDeptId(id).size() > 0){
            throw new RuntimeException("Cannot delete department as employees are assigned here");
        }
        departmentRepository.delete(departmentToBeDeleted);
    }
}
