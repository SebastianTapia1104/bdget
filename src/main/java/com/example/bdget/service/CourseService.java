package com.example.bdget.service;

import java.util.List;

import com.example.bdget.model.Course;

public interface CourseService {

    List<Course> getAllCourses();

    Course createCourse(Course course);
}
