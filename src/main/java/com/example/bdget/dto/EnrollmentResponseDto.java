package com.example.bdget.dto;

import java.util.List;

public class EnrollmentResponseDto {

    private String studentName;
    private List<CourseDetailDto> courses;
    private Double totalCost;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public List<CourseDetailDto> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDetailDto> courses) {
        this.courses = courses;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }
}
