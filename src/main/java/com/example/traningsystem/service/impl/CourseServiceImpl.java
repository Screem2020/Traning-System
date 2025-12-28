package com.example.traningsystem.service.impl;

import com.example.traningsystem.dao.CourseRepository;
import com.example.traningsystem.dao.TeacherRepository;
import com.example.traningsystem.dto.course.CourseRequest;
import com.example.traningsystem.exceptions.NotFoundException;
import com.example.traningsystem.mapper.CourseMapper;
import com.example.traningsystem.model.Course;
import com.example.traningsystem.model.Teacher;
import com.example.traningsystem.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final TeacherRepository teacherRepository;
    private final CourseMapper courseMapper;
    private final CourseRepository repository;

    @Override
    @Transactional(readOnly = true)
    public CourseRequest saveCourse(CourseRequest courseRequest) {
        Course entity = courseMapper.toEntity(courseRequest);
        return courseMapper.toDto(repository.save(entity));
    }
    @Transactional(readOnly = true)
    @Override
    public void deleteCourse(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CourseRequest findCourseByName(String name) {
        return repository.findByCourseName(name)
                .map(courseMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Course not found"));
    }
    @Transactional(readOnly = true)
    @Override
    public CourseRequest updateCourse(CourseRequest courseRequest) {
        Course course = repository.findById(courseRequest.getCourseId())
                .orElseThrow(() -> new NotFoundException("Course not found"));
        Teacher teacher = teacherRepository.findById(courseRequest.getCourseId())
                .orElseThrow(() -> new NotFoundException("Teacher not found"));
       courseMapper.updateEntityFromDto(courseRequest, course);
       course.setTeacher(teacher);
        return courseMapper.toDto(repository.save(course));
    }

    @Override
    public CourseRequest findCourseById(Long id) {
        return repository.findById(id)
                .map(courseMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Course not found"));
    }

    @Override
    public Page<CourseRequest> findAllCourses(Pageable pageable) {
        return repository.findAll(pageable).map(courseMapper::toDto);
    }
}
