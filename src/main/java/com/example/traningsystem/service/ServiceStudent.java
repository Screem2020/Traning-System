package com.example.traningsystem.service;

import com.example.traningsystem.dto.student.CreateStudentRequest;
import com.example.traningsystem.dto.student.MergeStudentRequest;
import com.example.traningsystem.dto.student.StudentDto;
import com.example.traningsystem.model.Student;

import java.util.List;

public interface ServiceStudent {
    List<StudentDto> findAllStudents();
    void addStudent(CreateStudentRequest student);
    Student updateStudent(CreateStudentRequest student);
    void deleteStudent(Long id);
    Student findStudentById(Long id);
}
