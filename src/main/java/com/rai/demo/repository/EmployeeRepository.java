package com.rai.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rai.demo.model.Employee;
 
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Transactional
	@Query(nativeQuery=true, value="select case when exists (select * from employee e where place=:place) then cast(1 as bit) else cast(0 as bit) end")
	boolean checkPlaceExists(@Param("place") String place);

	@Transactional
	@Query(nativeQuery=true, value="select * from employee e  where e.competencies like %:competency% and e.salary between :salaryfrom and :salaryto ")
	List<Employee> getEmpCompRangeInfo(@Param("competency") String competency, @Param("salaryfrom") int salaryfrom, @Param("salaryto") int salaryto);

	@Transactional
	@Modifying(clearAutomatically=true)
	@Query(nativeQuery=true, value="update employee e SET e.salary = e.salary + e.salary * :percentage/100  where place=:place")
	void updateEmployee(@Param("place") String place, @Param("percentage") int percentage);

	
}
