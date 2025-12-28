package com.example.traningsystem.service;

import com.example.traningsystem.dto.course.CourseRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {

    CourseRequest saveCourse(CourseRequest courseRequest);
    void deleteCourse(Long id);
    CourseRequest findCourseByName(String name);
    CourseRequest updateCourse(CourseRequest courseRequest);
    CourseRequest findCourseById(Long id);
    Page<CourseRequest> findAllCourses(Pageable pageable);

}
