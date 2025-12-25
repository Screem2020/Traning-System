package com.example.traningsystem.service;

import com.example.traningsystem.dao.CourseRepository;
import com.example.traningsystem.dao.TeacherRepository;
import com.example.traningsystem.dto.course.CourseRequest;
import com.example.traningsystem.exceptions.NotFoundException;
import com.example.traningsystem.mapper.CourseMapper;
import com.example.traningsystem.model.Course;
import com.example.traningsystem.model.Teacher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@AllArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final TeacherRepository teacherRepository;
    private final CourseMapper courseMapper;
    private final CourseRepository repository;

    @Override
    public CourseRequest saveCourse(CourseRequest courseRequest) {
        Course entity = courseMapper.toEntity(courseRequest);
        return courseMapper.toDto(repository.save(entity));
    }

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

    @Override
    public CourseRequest updateCourse(CourseRequest courseRequest) {
        Course course = repository.findById(courseRequest.getCourseId())
                .orElseThrow(() -> new NotFoundException("Course not found"));
        Teacher teacher = teacherRepository.findById(courseRequest.getCourseId())
                .orElseThrow(() -> new NotFoundException("Teacher not found"));
        course.setCourseName(courseRequest.getCourseName());
        course.setDescription(courseRequest.getDistraction());
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
    public List<CourseRequest> findAllCourses() {
        return repository.findAll()
                .stream()
                .map(courseMapper::toDto)
                .toList();
    }
}
