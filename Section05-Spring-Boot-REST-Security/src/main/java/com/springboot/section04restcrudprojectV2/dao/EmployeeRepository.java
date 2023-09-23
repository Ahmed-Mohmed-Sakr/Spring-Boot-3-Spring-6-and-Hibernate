package com.springboot.section04restcrudprojectV2.dao;

import com.springboot.section04restcrudprojectV2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.rest.core.annotation.RepositoryRestResource;


//@RepositoryRestResource(path = "employees")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that is every thing.!!!!!!1

}
