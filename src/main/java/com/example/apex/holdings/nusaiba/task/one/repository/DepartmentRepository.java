package com.example.apex.holdings.nusaiba.task.one.repository;

import com.example.apex.holdings.nusaiba.task.one.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
