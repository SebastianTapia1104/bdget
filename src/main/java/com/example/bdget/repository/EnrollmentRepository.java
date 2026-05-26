package com.example.bdget.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bdget.model.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
