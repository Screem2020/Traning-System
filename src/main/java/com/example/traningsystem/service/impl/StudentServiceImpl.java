package com.example.traningsystem.service.impl;

import com.example.traningsystem.dao.GroupRepository;
import com.example.traningsystem.dao.StudentRepository;
import com.example.traningsystem.dto.student.CreateStudentRequest;
import com.example.traningsystem.dto.student.StudentDto;
import com.example.traningsystem.exceptions.NotFoundException;
import com.example.traningsystem.mapper.StudentMapper;
import com.example.traningsystem.model.GroupEntity;
import com.example.traningsystem.model.StudentEntity;
import com.example.traningsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final GroupRepository groupRepository;
    private final StudentMapper studentMapper;

    @Transactional(readOnly = true)
    @Override
    public Page<StudentDto> findAllStudents(Pageable pageable) {
        return repository.findAll(pageable).map(studentMapper::toDto);
    }

    @Override
    public StudentDto addStudent(CreateStudentRequest studentRequest) {
        GroupEntity groupDto = groupRepository.findById(studentRequest.getGroupId())
                .orElseThrow(() -> new NotFoundException("GroupEntity not found with id: " + studentRequest.getGroupId()));
        StudentEntity entity = studentMapper.toEntity(studentRequest);
        entity.setGroup(groupDto);
        return studentMapper.toDto(repository.save(entity));
    }

    @Override
    public StudentDto updateStudent(CreateStudentRequest studentRequest) {
        StudentEntity studentById = repository.findById(studentRequest.getStudentId())
                .orElseThrow(() -> new NotFoundException("StudentEntity not found with id: " + studentRequest.getStudentId()));
        GroupEntity group = groupRepository.findById(studentRequest.getGroupId())
                .orElseThrow(() -> new NotFoundException("GroupEntity not found with id: " + studentRequest.getGroupId()));
        studentById.setFirstName(studentRequest.getFirstName());
        studentById.setLastName(studentRequest.getLastName());
        studentById.setGroup(group);
        return studentMapper.toDto(repository.save(studentById));
    }

    @Override
    public void deleteStudent(Long id) {
        StudentEntity student = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("StudentEntity not found with id: " + id));
        repository.delete(student);
    }

    @Transactional(readOnly = true)
    @Override
    public StudentDto findStudentById(Long id) {
        StudentEntity student = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("StudentEntity not found with id: " + id));
        return studentMapper.toDto(student);
    }
}
