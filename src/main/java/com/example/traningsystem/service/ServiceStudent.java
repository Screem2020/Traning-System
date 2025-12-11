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
    void deleteStudent(Integer id);
    void mergeStudent(MergeStudentRequest student);
    Student findStudentById(Integer id);
}
