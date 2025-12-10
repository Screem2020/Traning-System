package com.example.traningsystem.service.Impl;

import com.example.traningsystem.dao.memory.CourseDao;
import com.example.traningsystem.model.Course;
import com.example.traningsystem.service.ServiceCourse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ImplCourseInMemory implements ServiceCourse {

    private CourseDao repository;

    @Override
    public void saveCourse(Course course) {
        repository.saveCourse(course);
    }

    @Override
    public void deleteCourse(Integer id) {
        repository.deleteCourseById(id);
    }

    @Override
    public Course findCourseByName(String courseName) {
        return repository.findCourseByName(courseName);
    }

    @Override
    public Course updateCourse(Course course) {
        return repository.updateCourse(course);
    }

    @Override
    public void saveTeacher(Course course) {
        repository.saveTeacher(course);
    }

    @Override
    public Course findCourseById(Integer id) {
        return repository.findCourseById(id);
    }
}
