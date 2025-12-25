package com.example.traningsystem.service;

import com.example.traningsystem.dto.student.CreateStudentRequest;
import com.example.traningsystem.dto.student.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> findAllStudents();
    StudentDto addStudent(CreateStudentRequest studentRequest);
    StudentDto updateStudent(CreateStudentRequest studentRequest);
    void deleteStudent(Long id);
    StudentDto findStudentById(Long id);
}
