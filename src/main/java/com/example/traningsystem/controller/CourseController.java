package com.example.traningsystem.controller;

import com.example.traningsystem.dto.course.CourseRequest;
import com.example.traningsystem.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/course")
@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService service;
    @PostMapping()
    public CourseRequest save(@RequestBody CourseRequest courseRequest) {
        return service.saveCourse(courseRequest);
    }
    @GetMapping
    public Page<CourseRequest> all(
            @PageableDefault(
                page = 0,
                size = 10,
                sort = {"id", "courseName"},
                direction = Sort.Direction.DESC
            ) Pageable pageable) {
        return service.findAllCourses(pageable);
    }
    @GetMapping("/{id}")
    public CourseRequest findById(@PathVariable Long id) {
        return service.findCourseById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteCourse(id);
    }
    @PutMapping()
    public CourseRequest update(@RequestBody CourseRequest courseRequest) {
        return service.updateCourse(courseRequest);
    }
    @GetMapping("/{name}")
    public CourseRequest findCourseByName(@PathVariable String name) {
        return service.findCourseByName(name);
    }
}
