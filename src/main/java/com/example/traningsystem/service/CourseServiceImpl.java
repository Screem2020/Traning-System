package com.example.traningsystem.service;

import com.example.traningsystem.dao.CourseRepository;
import com.example.traningsystem.exceptions.NotFoundException;
import com.example.traningsystem.model.Course;
import com.example.traningsystem.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Primary;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@AllArgsConstructor
@Service
public class CourseServiceImpl implements ServiceCourse {

    private CourseRepository repository;

    @Override
    public void saveCourse(Course course) {
        repository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Course findCourseByName(String name) {
        return repository.findCourseByName(name);
    }

    @Override
    public Course updateCourse(Course course) {
        Course courseById = findCourseById(course.getCourseId());
        courseById.setName(course.getName());
        courseById.setDescription(course.getDescription());
        return repository.save(courseById);
    }

    @Override
    public void saveTeacher(Course course, Teacher teacher) {
        teacher.setFirstName(course.getTeacher().getFirstName());
        teacher.setLastName(course.getTeacher().getLastName());
        repository.save(course);
    }

    @Override
    public Course findCourseById(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Not found course with id: " + id));
    }


    @Override
    public List<Course> findAllCourses() {
        return repository.findAll();
    }
}
