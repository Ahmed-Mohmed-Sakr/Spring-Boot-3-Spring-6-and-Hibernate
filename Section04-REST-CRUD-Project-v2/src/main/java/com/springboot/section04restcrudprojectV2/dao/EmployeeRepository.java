package com.springboot.section04restcrudprojectV2.dao;

import com.springboot.section04restcrudprojectV2.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // that is every thing.!!!!!!1

}
