package com.example.apex.holdings.nusaiba.task.one.controller;

import com.example.apex.holdings.nusaiba.task.one.entity.Department;
import com.example.apex.holdings.nusaiba.task.one.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin()
@RestController
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService service;
    @PostMapping
    ResponseEntity<Department> addDepartment(@RequestBody Department department){
        return ResponseEntity.ok(service.insertDepartment(department));
    }
    @GetMapping("/{id}")
    ResponseEntity<Department> getDepartment(@PathVariable("id") Long id){
        return ResponseEntity.ok(service.getDepartment(id));
    }
    @GetMapping
    ResponseEntity<List<Department>> getAllDepartment(){
        return ResponseEntity.ok(service.getAllDepartment());
    }
    @PutMapping("/{id}")
    ResponseEntity<Department> updateDepartment(@PathVariable("id") Long id, @RequestBody Department department){
        return ResponseEntity.ok(service.updateDepartment(id, department));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Object> deleteDepartment(@PathVariable("id") Long id){
        try {
            service.deleteDepartment(id);
        }catch (RuntimeException e){
            return ResponseEntity.status(400).body(Optional.of(e.getMessage()));
        }
        return ResponseEntity.ok("Deleted");
    }
}
