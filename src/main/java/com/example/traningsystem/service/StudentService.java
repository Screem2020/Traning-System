package com.example.traningsystem.service;

import com.example.traningsystem.dto.student.CreateStudentRequest;
import com.example.traningsystem.dto.student.StudentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<StudentDto> findAllStudents(Pageable pageable);
    StudentDto addStudent(CreateStudentRequest studentRequest);
    StudentDto updateStudent(CreateStudentRequest studentRequest);
    void deleteStudent(Long id);
    StudentDto findStudentById(Long id);
}
