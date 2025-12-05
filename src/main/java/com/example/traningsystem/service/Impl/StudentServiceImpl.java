package com.example.traningsystem.service.Impl;

import com.example.traningsystem.dao.StudentRepository;
import com.example.traningsystem.model.Groups;
import com.example.traningsystem.model.Student;
import com.example.traningsystem.service.ServiceStudent;
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
        return repository.updateByStudent(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void mergeStudent(Student student) {
        Groups group = student.getGroup();
        group.getStudents().add(student);
    }

    @Override
    public Student findStudentById(int id) {
        return repository.findById(id).orElse(null);
    }
}
