package com.example.traningsystem.service;

import com.example.traningsystem.dao.GroupRepository;
import com.example.traningsystem.dao.StudentRepository;
import com.example.traningsystem.dto.student.CreateStudentRequest;
import com.example.traningsystem.dto.student.MergeStudentRequest;
import com.example.traningsystem.dto.student.StudentDto;
import com.example.traningsystem.dto.student.StudentMapperToEntity;
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

    @Override
    public List<StudentDto> findAllStudents() {
        return repository.findAll()
                .stream()
                .map(StudentMapperToEntity::toDto)
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
    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void mergeStudent(MergeStudentRequest student) {
        Groups group = student.getGroup();
        if (group != null) {
            //TODO:
        }
    }

    @Override
    public Student findStudentById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }
}
