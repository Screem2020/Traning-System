package com.example.traningsystem.service;

import com.example.traningsystem.dto.course.CreateCourseRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {

    CreateCourseRequest saveCourse(CreateCourseRequest courseRequest);
    void deleteCourse(Long id);
    CreateCourseRequest findCourseByName(String name);
    CreateCourseRequest updateCourse(CreateCourseRequest courseRequest);
    CreateCourseRequest findCourseById(Long id);
    Page<CreateCourseRequest> findAllCourses(Pageable pageable);

}
