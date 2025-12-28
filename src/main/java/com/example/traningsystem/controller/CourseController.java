package com.example.traningsystem.controller;

import com.example.traningsystem.dto.course.CourseRequest;
import com.example.traningsystem.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        PageRequest pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "name", "id"));
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
