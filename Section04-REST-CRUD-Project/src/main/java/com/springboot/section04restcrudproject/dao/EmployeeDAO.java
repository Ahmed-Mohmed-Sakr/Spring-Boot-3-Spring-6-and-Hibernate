package com.springboot.section04restcrudproject.dao;

import com.springboot.section04restcrudproject.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

}
