package com.rai.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.Max;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rai.demo.exception.EmployeeNotFoundException;
import com.rai.demo.model.Employee;
import com.rai.demo.model.FilterEntity;
import com.rai.demo.repository.EmployeeRepository;
 
@Service
public class EmployeeService {
     
    @Autowired
    EmployeeRepository repository;
     
    public List<Employee> getAllEmployees()
    {
        List<Employee> employeeList = repository.findAll();
         
        if(employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<Employee>();
        }
    }
    
	public List<Employee> updateEmployee(String place,  int percentage)  throws EmployeeNotFoundException
	{
		if(repository.checkPlaceExists(place)) {
		 repository.updateEmployee(place, percentage);
		 List<Employee> updateList=repository.findAll();
		 return updateList;
		}
		else throw new EmployeeNotFoundException("Looks like place : "+place +" seems to be not available or exists. ");
	}

	public List<Employee> getEmpCompRangeInfo(String competency, int salaryfrom, int salaryto) throws EmployeeNotFoundException
	{
		List<Employee> filterList=repository.getEmpCompRangeInfo(competency, salaryfrom, salaryto);
		if(filterList.size()>0)
			return filterList;
		else throw new EmployeeNotFoundException("No employee record exist for Competency: "+competency +" for salary range "+ salaryfrom +" between "+salaryto);
	}
     
//    public Employee getEmployeeById(Long id) throws EmployeeNotFoundException
//    {
//        Optional<Employee> employee = repository.findById(id);
//         
//        if(employee.isPresent()) {
//            return employee.get();
//        } else {
//            throw new EmployeeNotFoundException("No employee record exist for given id");
//        }
//    }
//     
//    public Employee createOrUpdateEmployee(Employee entity) throws EmployeeNotFoundException
//    {
//        Optional<Employee> employee = repository.findById(entity.getId());
//         
//        if(employee.isPresent())
//        {
//        	Employee newEntity = employee.get();
//            newEntity.setName(entity.getName());
//            //
//            newEntity = repository.save(newEntity);
//             
//            return newEntity;
//        } else {
//            entity = repository.save(entity);
//             
//            return entity;
//        }
//    }
//     
//    public void deleteEmployeeById(Long id) throws EmployeeNotFoundException
//    {
//        Optional<Employee> employee = repository.findById(id);
//         
//        if(employee.isPresent())
//        {
//            repository.deleteById(id);
//        } else {
//            throw new EmployeeNotFoundException("No employee record exist for given id");
//        }
//    }


}