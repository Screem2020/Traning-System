package com.example.traningsystem.dao;

import com.example.traningsystem.model.Groups;
import com.example.traningsystem.model.Student;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


@Repository
public class StudentsDao {
    private final List<Student> STUDENTS = new ArrayList<>();
    private final List<Groups> GROUPS = new ArrayList<>();


    public List<Student> findAllStudents() {
        return STUDENTS;
    }

    public void addStudent(Student student) {
        STUDENTS.add(student);
    }

    public Student findStudentById(int id) {
        return STUDENTS.stream()
                .filter(s -> s.getId() == id)
                .findFirst()
                .orElse(null);
    }


    public Student updateStudent(Student student) {
        Student studentById = findStudentById(student.getId());
        if (studentById != null) {
            studentById.setFirstName(student.getFirstName());
            studentById.setLastName(student.getLastName());
            return student;
        } throw new NullPointerException("Student with id " + student.getId() + " not found");
    }

    public void deleteStudent(Student student) {
        Student studentById = findStudentById(student.getId());
        if (studentById != null) {
            STUDENTS.remove(studentById);
        }
    }

    public void margeStudent(Student student, Groups group) {
        //TODO

    }
}
