package com.example.traningsystem.controller;

import com.example.traningsystem.dto.course.CourseDto;
import com.example.traningsystem.dto.course.CreateCourseRequest;
import com.example.traningsystem.service.CourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("api/v1/course")
@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseServiceImpl service;
    @PostMapping()
    public CourseDto save(@RequestBody CreateCourseRequest courseRequest) {
        return service.saveCourse(courseRequest);
    }
    @GetMapping
    public List<CourseDto> allCourses() {
        return service.findAllCourses();
    }
    @GetMapping("/{id}")
    public CourseDto findById(@PathVariable Long id) {
        return service.findCourseById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteCourse(id);
    }
    @PutMapping()
    public CourseDto update(@RequestBody CourseDto courseDto) {
        return service.updateCourse(courseDto);
    }
    @GetMapping("/{name}")
    public CourseDto findCourseByName(@PathVariable String name) {
        return service.findCourseByName(name);
    }
}
