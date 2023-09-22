package com.springboot.section04restcrudproject.service;

import com.springboot.section04restcrudproject.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
