package com.example.traningsystem.service;

import com.example.traningsystem.dto.student.CreateStudentRequest;
import com.example.traningsystem.dto.student.StudentDto;
import com.example.traningsystem.model.Student;

import java.util.List;

public interface ServiceStudent {
    List<StudentDto> findAllStudents();
    StudentDto addStudent(CreateStudentRequest studentRequest);
    StudentDto updateStudent(CreateStudentRequest studentRequest);
    void deleteStudent(Long id);
    StudentDto findStudentById(Long id);
}
