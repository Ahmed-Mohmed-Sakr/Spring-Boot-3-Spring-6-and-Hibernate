package com.springboot.section09jpa_hibernates_advanced.repository;

import com.springboot.section09jpa_hibernates_advanced.entity.Course;
import com.springboot.section09jpa_hibernates_advanced.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InstructorRepository extends JpaRepository<Instructor,Integer> {

    @Query("FROM Course where instructor.id = :theId")
    public List<Course> findCoursesByInstructorId(@Param("theId")int theId);
}
