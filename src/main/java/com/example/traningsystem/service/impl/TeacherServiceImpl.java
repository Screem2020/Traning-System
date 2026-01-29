package com.example.traningsystem.service.impl;

import com.example.traningsystem.dao.CourseRepository;
import com.example.traningsystem.dao.TeacherRepository;
import com.example.traningsystem.dto.teacher.CreateTeacherRequest;
import com.example.traningsystem.dto.teacher.TeacherDto;
import com.example.traningsystem.exceptions.NotFoundException;
import com.example.traningsystem.mapper.TeacherMapper;
import com.example.traningsystem.model.CourseEntity;
import com.example.traningsystem.model.TeacherEntity;
import com.example.traningsystem.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Transactional
@RequiredArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherMapper teacherMapper;
    private final CourseRepository courseRepository;
    private final TeacherRepository repository;

    @Override
    public TeacherDto addTeacher(CreateTeacherRequest teacherRequest) {
        CourseEntity course = courseRepository.findById(teacherRequest.getCourseId())
                .orElseThrow(() -> new NotFoundException("Course not found"));
        TeacherEntity teacher = teacherMapper.toEntity(teacherRequest);
        teacher.setCourse(course);
        return teacherMapper.toDto(repository.save(teacher));
    }

    @Transactional(readOnly = true)
    @Override
    public Page<TeacherDto> findAllTeachers(Pageable pageable) {
        return repository.findAll(pageable).map(teacherMapper::toDto);
    }

    @Transactional(readOnly = true)
    @Override
    public TeacherDto findTeacherById(Long id) {
        TeacherEntity teacher = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("TeacherEntity not found"));
        return teacherMapper.toDto(teacher);
    }

    @Override
    public void deleteTeacherById(Long id) {
        TeacherEntity teacher = repository.findById(id).orElseThrow(() -> new NotFoundException("TeacherEntity not found"));
        repository.delete(teacher);
    }
    @Transactional
    @Override
    public TeacherDto updateTeacher(TeacherDto teacherDto) {

        TeacherEntity teacher = repository.findById(teacherDto.getId())
                .orElseThrow(() -> new NotFoundException("TeacherEntity not found with id: " + teacherDto.getId()));
        CourseEntity course = courseRepository.findById(teacherDto.getCourseId())
                .orElseThrow(() -> new NotFoundException("Course not found with id: " + teacherDto.getCourseId()));
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setCourse(course);
        return teacherMapper.toDto(teacher);
    }
}
