package com.example.traningsystem.service;

import com.example.traningsystem.model.Course;

public interface ServiceCourse {

    void saveCourse(Course course);
    void deleteCourse(Integer id);
    Course findCourseByName(String courseName);
    Course updateCourse(Course course);
    void saveTeacher(Course course);
    Course findCourseById(Integer id);
}
