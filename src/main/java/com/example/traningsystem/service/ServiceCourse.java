package com.example.traningsystem.service;

import com.example.traningsystem.model.Course;
import com.example.traningsystem.model.Teacher;

import java.util.List;

public interface ServiceCourse {

    void saveCourse(Course course);
    void deleteCourse(Long id);
    Course findCourseByName(String name);
    Course updateCourse(Course course);
    void saveTeacher(Course course, Teacher teacher);
    Course findCourseById(Long id);
    List<Course> findAllCourses();
}
