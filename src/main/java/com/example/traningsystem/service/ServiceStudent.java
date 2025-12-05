package com.example.traningsystem.service;

import com.example.traningsystem.model.Student;

import java.util.List;

public interface ServiceStudent {
    List<Student> findAllStudents();
    void addStudent(Student student);
    Student updateStudent(Student student);
    void deleteStudent(Integer id);
    void mergeStudent(Student student);
    Student findStudentById(int id);
}
