package com.springboot.section03springboothibernatejpacrud.dao;

import com.springboot.section03springboothibernatejpacrud.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    void update(Student student);
}
