package com.springboot.section09jpa_hibernates_advanced.repository;

import com.springboot.section09jpa_hibernates_advanced.entity.InstructorDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorDetailRepository extends JpaRepository<InstructorDetail,Integer> {
}
