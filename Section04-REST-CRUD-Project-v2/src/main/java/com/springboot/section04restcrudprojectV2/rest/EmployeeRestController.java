/*
no longer needed after this dependancy

<dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-rest</artifactId>
        </dependency>

 */

package com.springboot.section04restcrudprojectV2.rest;

import com.springboot.section04restcrudprojectV2.entity.Employee;
import com.springboot.section04restcrudprojectV2.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee thEmployee = employeeService.findById(employeeId);

        if(thEmployee == null)
            throw new RuntimeException("Employee id not found - " + employeeId);

        return thEmployee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee thEmployee) {

        // set id to 0 so you alweys force merge to add new element
        thEmployee.setId(0);

        Employee dpEmployee = employeeService.save(thEmployee);

        return dpEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee thEmployee) {

        Employee dpEmployee = employeeService.save(thEmployee);

        return dpEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee theEmployee = employeeService.findById(employeeId);

        if (theEmployee == null) {
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted employee id - " + employeeId;
    }



}
