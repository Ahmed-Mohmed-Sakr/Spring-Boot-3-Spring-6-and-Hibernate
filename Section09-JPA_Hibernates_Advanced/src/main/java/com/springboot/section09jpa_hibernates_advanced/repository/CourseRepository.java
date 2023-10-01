package com.springboot.section09jpa_hibernates_advanced.repository;

import com.springboot.section09jpa_hibernates_advanced.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
