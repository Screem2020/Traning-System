package com.example.traningsystem.service;

import com.example.traningsystem.dto.course.CourseDto;
import com.example.traningsystem.dto.course.CreateCourseRequest;

import java.util.List;

public interface CourseService {

    CourseDto saveCourse(CreateCourseRequest courseRequest);
    void deleteCourse(Long id);
    CourseDto findCourseByName(String name);
    CourseDto updateCourse(CourseDto courseDto);
    CourseDto findCourseById(Long id);
    List<CourseDto> findAllCourses();
}
