package com.example.traningsystem.service;

import com.example.traningsystem.dao.GroupRepository;
import com.example.traningsystem.dao.StudentRepository;
import com.example.traningsystem.dto.student.CreateStudentRequest;
import com.example.traningsystem.dto.student.StudentDto;
import com.example.traningsystem.mapper.StudentMapper;
import com.example.traningsystem.model.Groups;
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
    private final GroupRepository groupRepository;
    private final StudentMapper studentMapper;

    @Override
    public List<StudentDto> findAllStudents() {
        return repository.findAll()
                .stream()
                .map(studentMapper::toEntity)
                .toList();
    }

    @Override
    public void addStudent(CreateStudentRequest studentRequest) {
        Groups groupFound = groupRepository
                .findById(studentRequest.getGroupId())
                .orElseThrow(() -> new RuntimeException("Group not found"));
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setGroup(groupFound);
        repository.save(student);
    }

    @Override
    public Student updateStudent(CreateStudentRequest studentRequest) {
        Student studentById = findStudentById(studentRequest.getGroupId());
        if (studentById != null) {
            studentById.setFirstName(studentRequest.getFirstName());
            studentById.setLastName(studentRequest.getLastName());
            return repository.save(studentById);
        } throw new RuntimeException("Student not found");
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Student findStudentById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
