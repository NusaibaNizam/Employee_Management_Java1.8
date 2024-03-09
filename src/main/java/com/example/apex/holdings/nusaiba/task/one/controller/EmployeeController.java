package com.example.apex.holdings.nusaiba.task.one.controller;

import com.example.apex.holdings.nusaiba.task.one.entity.Employee;
import com.example.apex.holdings.nusaiba.task.one.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin()
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService service;

    @PostMapping
    ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(service.insertEmployee(employee));
    }

    @GetMapping("/{id}")
    ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.getEmployee(id));
    }

    @GetMapping
    ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok(service.getAllEmployee());
    }

    @PutMapping("/{id}")
    ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        return ResponseEntity.ok(service.updateEmployee(id, employee));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteEmployee(@PathVariable("id") Long id){
        service.deleteEmployee(id);
        return ResponseEntity.ok("Deleted");
    }
}
