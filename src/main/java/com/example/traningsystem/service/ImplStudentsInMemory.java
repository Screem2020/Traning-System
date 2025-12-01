package com.example.traningsystem.service;

import com.example.traningsystem.model.Student;
import com.example.traningsystem.dao.StudentsDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ImplStudentsInMemory implements ServiceStudent{

    private final StudentsDao repository;

    @Override
    public List<Student> findAllStudents() {
        return repository.findAllStudents();
    }

    @Override
    public void addStudent(Student student) {
        repository.addStudent(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.updateStudent(student);
    }

    @Override
    public void deleteStudent(Student student) {
        repository.deleteStudent(student);
    }

    @Override
    public void mergeStudent(Student student) {

    }

    @Override
    public Student findStudentById(int id) {
        return repository.findStudentById(id);
    }
}
