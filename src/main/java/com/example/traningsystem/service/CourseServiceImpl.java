package com.example.traningsystem.service;

import com.example.traningsystem.dao.CourseRepository;
import com.example.traningsystem.model.Course;
import com.example.traningsystem.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Primary;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

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
    public void deleteCourse(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Course findCourseByName(String courseName) {
        return repository.findCourseByCourseName(courseName);
    }

    @Override
    public Course updateCourse(Course course) {
        Course courseById = findCourseById(course.getCourseId());
        courseById.setName(course.getName());
        courseById.setDescription(course.getDescription());
        return repository.save(courseById);
    }

    @Override
    public void saveTeacher(Course course) {
        Teacher teacher = course.getTeacher();
        teacher.setFirstName(course.getTeacher().getFirstName());
        teacher.setLastName(course.getTeacher().getLastName());
        repository.save(course);
    }

    @SneakyThrows
    @Override
    public Course findCourseById(Integer id) {
        return repository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
}
