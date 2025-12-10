package com.example.traningsystem.service;

import com.example.traningsystem.dao.StudentRepository;
import com.example.traningsystem.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class StudentServiceImpl implements ServiceStudent {
    private final StudentRepository repository;

    @Override
    public List<Student> findAllStudents() {
        return repository.findAll();
    }

    @Override
    public void addStudent(Student student) {
        repository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        Student studentById = findStudentById(student.getId());
        if (studentById != null) {
            studentById.setFirstName(student.getFirstName());
            studentById.setLastName(student.getLastName());
            return repository.save(studentById);
        }
        throw new NullPointerException("Student with id " + student.getId() + " not found");
    }

    @Override
    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void mergeStudent(Student student) {

    }

    @Override
    public Student findStudentById(int id) {
        return repository.findById(id).orElse(null);
    }
}
