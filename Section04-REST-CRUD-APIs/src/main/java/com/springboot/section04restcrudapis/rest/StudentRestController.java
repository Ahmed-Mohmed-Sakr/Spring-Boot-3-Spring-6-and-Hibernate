package com.springboot.section04restcrudapis.rest;

import com.springboot.section04restcrudapis.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData() {

        theStudents = new ArrayList<>();

        theStudents.add(new Student("ahmed", "sakr"));
        theStudents.add(new Student("zainb", "sakr"));
        theStudents.add(new Student("ali", "nader"));

    }


    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student geStudent(@PathVariable int studentId) {

        if (studentId >= theStudents.size() || studentId < 0)
            throw new StudentNotFoundException("Student id not found - " + studentId);

        return theStudents.get(studentId);
    }

}
