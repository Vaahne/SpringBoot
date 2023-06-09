package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
