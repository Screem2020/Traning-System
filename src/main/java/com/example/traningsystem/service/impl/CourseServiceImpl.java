package com.example.traningsystem.service.impl;

import com.example.traningsystem.dao.CourseRepository;
import com.example.traningsystem.dao.TeacherRepository;
import com.example.traningsystem.dto.course.CreateCourseRequest;
import com.example.traningsystem.exceptions.NotFoundException;
import com.example.traningsystem.mapper.CourseMapper;
import com.example.traningsystem.model.CourseEntity;
import com.example.traningsystem.model.TeacherEntity;
import com.example.traningsystem.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final TeacherRepository teacherRepository;
    private final CourseMapper courseMapper;
    private final CourseRepository repository;

    @Override
    public CreateCourseRequest saveCourse(CreateCourseRequest courseRequest) {
        CourseEntity entity = courseMapper.toEntity(courseRequest);
        return courseMapper.toDto(repository.save(entity));
    }

    @Override
    public void deleteCourse(Long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public CreateCourseRequest findCourseByName(String name) {
        return repository.findByCourseName(name)
                .map(courseMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Course not found"));
    }

    @Override
    public CreateCourseRequest updateCourse(CreateCourseRequest courseRequest) {
        CourseEntity course = repository.findById(courseRequest.getId())
                .orElseThrow(() -> new NotFoundException("Course not found"));
        TeacherEntity teacher = teacherRepository.findById(courseRequest.getId())
                .orElseThrow(() -> new NotFoundException("TeacherEntity not found"));
       courseMapper.updateEntityFromDto(courseRequest, course);
       course.setTeacher(teacher);
        return courseMapper.toDto(repository.save(course));
    }
    @Transactional(readOnly = true)
    @Override
    public CreateCourseRequest findCourseById(Long id) {
        return repository.findById(id)
                .map(courseMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Course not found"));
    }

    @Transactional(readOnly = true)
    @Override
    public Page<CreateCourseRequest> findAllCourses(Pageable pageable) {
        return repository.findAll(pageable).map(courseMapper::toDto);
    }
}
