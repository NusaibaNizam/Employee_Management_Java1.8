package com.example.apex.holdings.nusaiba.task.one.controller;

import com.example.apex.holdings.nusaiba.task.one.entity.Employee;
import com.example.apex.holdings.nusaiba.task.one.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/employee_of_department")
public class EmployeeByDepartmentController {
    @Autowired
    EmployeeService service;

    @GetMapping("/{id}")
    ResponseEntity<List<Employee>> getAllEmployeeByDepartment(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.getAllEmployeeByDepartmentId(id));
    }
}
