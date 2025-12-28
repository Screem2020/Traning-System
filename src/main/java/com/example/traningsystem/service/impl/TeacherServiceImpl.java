package com.example.traningsystem.service.impl;

import com.example.traningsystem.dao.CourseRepository;
import com.example.traningsystem.dao.TeacherRepository;
import com.example.traningsystem.dto.teacher.CreateTeacherRequest;
import com.example.traningsystem.dto.teacher.TeacherDto;
import com.example.traningsystem.exceptions.NotFoundException;
import com.example.traningsystem.mapper.TeacherMapper;
import com.example.traningsystem.model.Course;
import com.example.traningsystem.model.Teacher;
import com.example.traningsystem.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherMapper teacherMapper;
    private final CourseRepository courseRepository;
    private final TeacherRepository repository;

    @Override
    public TeacherDto addTeacher(CreateTeacherRequest teacherRequest) {
        Course course = courseRepository.findById(teacherRequest.getCourseId())
                .orElseThrow(() -> new NotFoundException("Course not found"));
        Teacher teacher = teacherMapper.toEntity(teacherRequest);
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
        Teacher teacher = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Teacher not found"));
        return teacherMapper.toDto(teacher);
    }

    @Override
    public void deleteTeacherById(Long id) {
        Teacher teacher = repository.findById(id).orElseThrow(() -> new NotFoundException("Teacher not found"));
        repository.delete(teacher);
    }

    @Override
    public TeacherDto updateTeacher(TeacherDto teacherDto) {
        Teacher teacher = repository.findById(teacherDto.getId())
                .orElseThrow(() -> new NotFoundException("Teacher not found with id: " + teacherDto.getId()));
        Course course = courseRepository.findById(teacherDto.getCourseId())
                .orElseThrow(() -> new NotFoundException("Course not found with id: " + teacherDto.getCourseId()));
        teacher.setFirstName(teacherDto.getFirstName());
        teacher.setLastName(teacherDto.getLastName());
        teacher.setCourse(course);
        return teacherMapper.toDto(repository.save(teacher));
    }
}
