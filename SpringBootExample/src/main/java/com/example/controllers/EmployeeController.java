package com.example.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exception.EmployeeNotFoundException;
import com.example.model.Employee;
import com.example.repo.EmployeeRepository;
import com.example.validations.EmployeeValidation;
@RestController
@RequestMapping("/api/v1")
public class EmployeeController  {

	
	@Autowired
	//@Qualifier("empRepo")
	private EmployeeRepository empRepo;
	
	/*
	 * @Autowired(required=false) EmployeeValidation valid;
	 */
	
	
	@PostMapping("/emp")
	public Employee createEmployee(@RequestBody Employee employee) throws Exception {
		boolean val= new EmployeeValidation().check(employee);
		System.out.println(""+employee);
		System.out.println("id is "+employee.getId());
		if(val) {
			return empRepo.save(employee);
		}
		return null;
	}
	
	@GetMapping("test")
	public String display() {
		return "/sdsw     elcome.jsp";
	}
	
	@GetMapping("/findemps")
	public List<Employee> getAllEmps(){
		return empRepo.findAll();
	}
	
	@GetMapping("/empid/{id}")
	public Optional<Employee> getByid(@PathVariable("id") Long id) {
		return empRepo.findById(id);
	}
	
	@DeleteMapping("/delemp/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id){
		 empRepo.deleteById(id);
		 return ResponseEntity.status(HttpStatus.ACCEPTED).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,
			@RequestBody Employee employee) throws EmployeeNotFoundException{
		Employee emp=empRepo.findById(id).orElseThrow(()->
		new EmployeeNotFoundException(" Employee Not Found with Employee ID : "+id));
		emp.setEmail(employee.getEmail());
		emp.setFirstName(employee.getFirstName());
		emp.setLastName(employee.getLastName());
		empRepo.save(emp);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}

