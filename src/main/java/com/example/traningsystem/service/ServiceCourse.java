package com.example.traningsystem.service;

import com.example.traningsystem.model.Course;
import com.example.traningsystem.model.Teacher;

import java.util.List;

public interface ServiceCourse {

    void saveCourse(Course course);
    void deleteCourse(Integer id);
    Course findCourseByName(String name);
    Course updateCourse(Course course);
    void saveTeacher(Course course, Teacher teacher);
    Course findCourseById(Integer id);
    List<Course> findAllCourses();
}
