package com.example.traningsystem.service;

import com.example.traningsystem.dao.TeacherRepository;
import com.example.traningsystem.exceptions.NotFoundException;
import com.example.traningsystem.model.Teacher;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Primary
@Service
public class TeacherServiceImpl implements ServiceTeacher {
    private TeacherRepository repository;

    public void save(Teacher teacher) {
        repository.save(teacher);
    }

    @Override
    public List<Teacher> findAllTeachers() {
        return List.of();
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


    public Teacher updateTeacher(Teacher teacher) {
        Teacher findByTeacher = findTeacherById(teacher.getTeacherId());
        if (findByTeacher != null) {
            findByTeacher.setFirstName(teacher.getFirstName());
            findByTeacher.setLastName(teacher.getLastName());
            return repository.save(findByTeacher);
        }
        throw new NotFoundException("Teacher not found with id: " + teacher.getTeacherId());
    }
}
