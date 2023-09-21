package com.springboot.section03springboothibernatejpacrud.dao;

import com.springboot.section03springboothibernatejpacrud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName asc ", Student.class);

        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> thQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);

        thQuery.setParameter("theData", theLastName);

        return thQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }


}
