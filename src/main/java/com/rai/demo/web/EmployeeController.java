package com.rai.demo.web;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rai.demo.exception.EmployeeNotFoundException;
import com.rai.demo.model.Employee;
import com.rai.demo.service.EmployeeService;
 
@RestController
@RequestMapping("/employee")
public class EmployeeController
{
    @Autowired
    EmployeeService service;
 
    @GetMapping("/getAllEmpoyees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> list = service.getAllEmployees();
        return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
    }
    
    @PutMapping("/place/{place}/salary/{percentage}")
    public ResponseEntity<?> updateEmployee(@PathVariable("place") String place, 
    			@PathVariable("percentage") @Max(55) int percentage) throws EmployeeNotFoundException {
    	List<Employee> updated = service.updateEmployee(place, percentage);
        return new ResponseEntity<List<Employee>>(updated, new HttpHeaders(), HttpStatus.OK);
    }
    
    @GetMapping("/competency/{competency}/salaryange/{salaryfrom}/{salaryto}")
    public ResponseEntity<?> getByCompAndSalaryRange(@PathVariable("competency") String competency,
    		@PathVariable("salaryfrom") @Min(10000) int salaryfrom, @PathVariable("salaryto") @Max(400000) int salaryto) throws EmployeeNotFoundException {
    	List<Employee> updated = service.getEmpCompRangeInfo(competency, salaryfrom, salaryto);
        return new ResponseEntity<List<Employee>>(updated, new HttpHeaders(), HttpStatus.OK);
    }
    
}