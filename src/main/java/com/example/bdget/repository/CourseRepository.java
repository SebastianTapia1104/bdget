package com.example.bdget.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bdget.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
