package com.example.traningsystem.service;

import com.example.traningsystem.dao.CourseRepository;
import com.example.traningsystem.dao.TeacherRepository;
import com.example.traningsystem.dto.teacher.CreateTeacherRequest;
import com.example.traningsystem.dto.teacher.TeacherDto;
import com.example.traningsystem.exceptions.NotFoundException;
import com.example.traningsystem.mapper.GroupMapper;
import com.example.traningsystem.mapper.TeacherMapper;
import com.example.traningsystem.model.Course;
import com.example.traningsystem.model.Teacher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@AllArgsConstructor
@Service
public class TeacherServiceImpl implements ServiceTeacher {
    private final TeacherMapper teacherMapper;
    private final CourseRepository courseRepository;
    private final TeacherRepository repository;
    private final GroupMapper groupMapper;

    @Override
    public TeacherDto addTeacher(CreateTeacherRequest teacherRequest) {
        Course course = courseRepository.findById(teacherRequest.getCourseId())
                .orElseThrow(() -> new NotFoundException("Course not found"));
        Teacher teacher = teacherMapper.toEntity(teacherRequest);
        teacher.setCourse(course);
        return teacherMapper.toDto(repository.save(teacher));
    }

    @Override
    public List<TeacherDto> findAllTeachers() {
        return repository.findAll()
                .stream()
                .map(teacherMapper::toDto)
                .toList();
    }

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
