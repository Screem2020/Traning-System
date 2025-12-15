package com.example.traningsystem.service;

import com.example.traningsystem.dao.GroupRepository;
import com.example.traningsystem.dao.StudentRepository;
import com.example.traningsystem.dto.student.CreateStudentRequest;
import com.example.traningsystem.dto.student.StudentDto;
import com.example.traningsystem.exceptions.NotFoundException;
import com.example.traningsystem.mapper.StudentMapper;
import com.example.traningsystem.model.Group;
import com.example.traningsystem.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Service
@AllArgsConstructor
public class StudentServiceImpl implements ServiceStudent {
    private final StudentRepository repository;
    private final GroupRepository groupRepository;
    private final StudentMapper studentMapper;

    @Override
    public List<StudentDto> findAllStudents() {
        return repository.findAll()
                .stream()
                .map(studentMapper::toDto)
                .toList();
    }
    @Override
    public StudentDto addStudent(CreateStudentRequest studentRequest) {
            Group groupDto = groupRepository.findById(studentRequest.getGroupId())
                    .orElseThrow(() -> new NotFoundException("Group not found with id: " + studentRequest.getGroupId()));
        Student entity = studentMapper.toEntity(studentRequest);
        entity.setGroup(groupDto);
        return studentMapper.toDto(repository.save(entity));
    }
    @Override
    public Student updateStudent(CreateStudentRequest studentRequest) {
        Student studentById = findStudentById(studentRequest.getGroupId());
        if (studentById != null) {
            studentById.setFirstName(studentRequest.getFirstName());
            studentById.setLastName(studentRequest.getLastName());
            studentById.setGroup(studentRequest.getGroup());
            return studentById;
        }
        throw new NotFoundException("Student not found with id: " + studentRequest.getGroupId());
    }
    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Student findStudentById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Student not found with id: " + id));
    }
}
