package com.example.traningsystem.service.Implmemory;

import com.example.traningsystem.model.Student;
import com.example.traningsystem.dao.memory.StudentsDao;
import com.example.traningsystem.service.ServiceStudent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class ImplStudentsInMemory implements ServiceStudent {

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
    public void deleteStudent(Integer id) {
        repository.deleteStudent(id);
    }

    @Override
    public void mergeStudent(Student student) {
        repository.margeStudent(student);
    }

    @Override
    public Student findStudentById(int id) {
        return repository.findStudentById(id);
    }
}
