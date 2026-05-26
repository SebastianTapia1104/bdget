package com.example.bdget.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bdget.dto.CourseDetailDto;
import com.example.bdget.dto.EnrollmentRequest;
import com.example.bdget.dto.EnrollmentResponseDto;
import com.example.bdget.model.Course;
import com.example.bdget.model.Enrollment;
import com.example.bdget.repository.CourseRepository;
import com.example.bdget.repository.EnrollmentRepository;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public EnrollmentResponseDto createEnrollment(EnrollmentRequest request) {
        if (request.getStudentName() == null || request.getStudentName().isBlank()) {
            throw new RuntimeException("El nombre del estudiante es obligatorio");
        }
        if (request.getCourseIds() == null || request.getCourseIds().isEmpty()) {
            throw new RuntimeException("Debe seleccionar al menos un curso");
        }

        List<Course> courses = new ArrayList<>();
        double totalCost = 0.0;

        for (Long courseId : request.getCourseIds()) {
            Course course = courseRepository.findById(courseId)
                    .orElseThrow(() -> new RuntimeException("Curso no encontrado con id: " + courseId));
            courses.add(course);
            totalCost += course.getCost();
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setStudentName(request.getStudentName());
        enrollment.setCourses(courses);
        enrollment.setTotalCost(totalCost);
        enrollmentRepository.save(enrollment);

        List<CourseDetailDto> courseDetails = courses.stream()
                .map(c -> new CourseDetailDto(c.getId(), c.getName(), c.getCost()))
                .collect(Collectors.toList());

        EnrollmentResponseDto response = new EnrollmentResponseDto();
        response.setStudentName(enrollment.getStudentName());
        response.setCourses(courseDetails);
        response.setTotalCost(totalCost);

        return response;
    }
}
