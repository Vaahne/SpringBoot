package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.ComponentScan;
//
//import com.example.model.Employee;
//import com.example.repo.EmployeeRepository;

@SpringBootApplication
@EnableJpaRepositories("com.example.repo")
@EntityScan("com.example.model")
@ComponentScan(basePackages = {"com.example.controllers","com.example.repo"})
@EnableAutoConfiguration
public class SpringBootExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExampleApplication.class,args);
//		ApplicationContext applicationContext=SpringApplication.run(SpringBootExampleApplication.class,args);
//		SpringApplication.run(SpringBootExampleApplication.class, args);
//		 EmployeeRepository emprep=applicationContext.getBean(EmployeeRepository.class); 
//		 Employee emp=new Employee(); 
//		 emp.setFirstName("Ganesha"); 
//		 emp.setLastName("Shiv");
//		 emp.setEmail("asdf@asdf"); 
//		 Employee e=emprep.save(emp);
//		 System.out.println(e);
		 
	}

}
