package com.example.traningsystem.service;

import com.example.traningsystem.dao.CourseRepository;
import com.example.traningsystem.dao.TeacherRepository;
import com.example.traningsystem.dto.teacher.CreateTeacherRequest;
import com.example.traningsystem.dto.teacher.TeacherDto;
import com.example.traningsystem.exceptions.NotFoundException;
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
    private TeacherRepository repository;

    @Override
    public TeacherDto addTeacher(CreateTeacherRequest teacherRequest) {
        Course teacherByCourseDto = courseRepository.findById(teacherRequest.getCourseId())
                .orElseThrow(() -> new NotFoundException("Teacher not found"));
        Teacher entity = teacherMapper.toEntity(teacherRequest);
        entity.setCourse(teacherByCourseDto);
        teacherByCourseDto.setTeacher(entity);
        return teacherMapper.toDto(repository.save(entity));
    }

    @Transactional(readOnly = true)
    @Override
    public List<TeacherDto> findAllTeachers() {
       return repository.findAll()
               .stream()
               .map(teacherMapper::toDto)
               .toList();
    }

    @Override
    public Teacher findTeacherById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Teacher not found with id: " + id));
    }
    @Override
    public void deleteTeacherById(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        }
        throw new NotFoundException("Teacher not found with id: " + id);
    }
    @Override
    public Teacher updateTeacher(TeacherDto teacherDto) {
        Teacher teacherById = findTeacherById(teacherDto.getId());
        if (teacherById != null) {
            teacherById.setFirstName(teacherDto.getFirstName());
            teacherById.setLastName(teacherDto.getLastName());
            teacherById.setCourse(teacherDto.getCourseDto());
            return teacherById;
        }
        throw new NotFoundException("Teacher not found with id: " + teacherDto.getId());
    }
}
