package com.springboot.section03springboothibernatejpacrud;

import com.springboot.section03springboothibernatejpacrud.dao.StudentDAO;
import com.springboot.section03springboothibernatejpacrud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Section03SpringBootHibernateJpaCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(Section03SpringBootHibernateJpaCrudApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner ->  {
//            createStudent(studentDAO);
//            createMultipleStudents(studentDAO);
//            readStudent(studentDAO);
//            queryForStudents(studentDAO);
//            queryForStudentsByLastName(studentDAO);

            updateStudent(studentDAO);

        };
    }

    private void updateStudent(StudentDAO studentDAO) {
        Student tempStudent = studentDAO.findById(1);

        tempStudent.setFirstName("Mai");

        studentDAO.update(tempStudent);

        System.out.println(tempStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findByLastName("sakr");

        for (Student tempStudent :  theStudents){
            System.out.println(tempStudent);
        }
    }

    private void queryForStudents(StudentDAO studentDAO) {

        List<Student> theStudents = studentDAO.findAll();

        for (Student tempStudent :  theStudents){
            System.out.println(tempStudent);
        }

    }

    private void readStudent(StudentDAO studentDAO) {
        System.out.println("creating new student object .......");
        Student tempStudent = new Student("ahmed","sakr","ahmedsakr07407@gmail.com");

        System.out.println("Saving the student ........");
        studentDAO.save(tempStudent);

        int theId = tempStudent.getId();
        System.out.println("Saved student, Generated id: " + theId);

        System.out.println("Retriving student with id: " + theId);
        Student myStudent = studentDAO.findById(theId);
        System.out.println("Found the student :" + myStudent);
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("creating 3 student object .......");
        Student tempStudent1 = new Student("nada","ali","nada@gmail.com");
        Student tempStudent2 = new Student("ali","sakr","ali@gmail.com");
        Student tempStudent3 = new Student("zainb","nader","zainb@gmail.com");

        System.out.println("Saving 3 student ........");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {

        System.out.println("creating new student object .......");
        Student tempStudent = new Student("ahmed","sakr","ahmedsakr07407@gmail.com");

        System.out.println("Saving the student ........");
        studentDAO.save(tempStudent);

        System.out.println("Saved student, Generated id: " + tempStudent.getId());

    }


}
