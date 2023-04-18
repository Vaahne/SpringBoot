package com.example.validations;

import com.example.model.Employee;

public class EmployeeValidation {
	public boolean check(Employee emp) throws Exception {
		if(emp.getFirstName()==null) {
			throw new Exception("Employee Null");
			
		}
		System.out.println("Employee "+emp.toString());
		return true;
	}
}
