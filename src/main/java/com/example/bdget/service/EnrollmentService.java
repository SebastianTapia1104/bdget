package com.example.bdget.service;

import com.example.bdget.dto.EnrollmentRequest;
import com.example.bdget.dto.EnrollmentResponseDto;

public interface EnrollmentService {

    EnrollmentResponseDto createEnrollment(EnrollmentRequest request);
}
