package com.springboot.section09jpa_hibernates_advanced.repository;

import com.springboot.section09jpa_hibernates_advanced.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor,Integer> {
}
