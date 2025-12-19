package com.example.traningsystem.service;

import com.example.traningsystem.dao.CourseRepository;
import com.example.traningsystem.dao.TeacherRepository;
import com.example.traningsystem.dto.course.CourseDto;
import com.example.traningsystem.dto.course.CreateCourseRequest;
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
public class CourseServiceImpl implements ServiceCourse {

    private final TeacherRepository teacherRepository;
    private final CourseMapper courseMapper;
    private final CourseRepository repository;

    @Override
    public CourseDto saveCourse(CreateCourseRequest courseRequest) {
        Teacher teacherDto = teacherRepository
                .findById(courseRequest.getTeacherDto().getId())
                .orElseThrow(() -> new NotFoundException("Teacher not found"));
        Course entity = courseMapper.fromCreateRequest(courseRequest);
        entity.setTeacher(teacherDto);
        Course save = repository.save(entity);
        return courseMapper.toDto(save);
    }
    @Override
    public void deleteCourse(Long id) {
        repository.deleteById(id);
    }

    @Override
    public CourseDto findCourseByName(String name) {
        return repository.findByName(name)
                .map(courseMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Course not found"));
    }
    @Override
    public CourseDto updateCourse(CourseDto courseDto) {
        Course course = repository.findById(courseDto.getCourseId()).orElseThrow(() -> new NotFoundException("Course not found"));
        course.setName(courseDto.getCourseName());
        course.setDescription(courseDto.getDistraction());
        if (courseDto.getTeacherDto() != null) {
            Long teacherId = courseDto.getTeacherDto().getTeacherId();
            Teacher teacher = teacherRepository.findById(teacherId)
                    .orElseThrow(() -> new NotFoundException("Teacher not found"));
            course.setTeacher(teacher);
        }
        return courseMapper.toDto(course);
    }
    @Override
    public CourseDto findCourseById(Long id) {
        return repository.findById(id)
                .map(courseMapper::toDto)
                .orElseThrow(() -> new NotFoundException("Course not found"));
    }

    @Override
    public List<CourseDto> findAllCourses() {
        return repository.findAll()
                .stream()
                .map(courseMapper::toDto)
                .toList();
    }
}
