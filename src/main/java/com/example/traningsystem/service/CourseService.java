package com.example.traningsystem.service;

import com.example.traningsystem.dto.course.CourseRequest;

import java.util.List;

public interface CourseService {

    CourseRequest saveCourse(CourseRequest courseRequest);
    void deleteCourse(Long id);
    CourseRequest findCourseByName(String name);
    CourseRequest updateCourse(CourseRequest courseRequest);
    CourseRequest findCourseById(Long id);
    List<CourseRequest> findAllCourses();
}
