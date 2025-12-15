package com.example.traningsystem.controller;

import com.example.traningsystem.dto.course.CourseDto;
import com.example.traningsystem.dto.course.CreateCourseRequest;
import com.example.traningsystem.model.Course;
import com.example.traningsystem.service.CourseServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("api/v1/course")
@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseServiceImpl service;
    @PostMapping("/save")
    public CourseDto save(@RequestBody CreateCourseRequest courseRequest) {
        return service.saveCourse(courseRequest);
    }
    @GetMapping
    public List<CourseDto> allCourses() {
        return service.findAllCourses();
    }
    @GetMapping("/find_course/{id}")
    public CourseDto findById(@PathVariable Long id) {
        return service.findCourseById(id);
    }
    @DeleteMapping("/delete_course/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteCourse(id);
    }
    @PutMapping("/update_course")
    public CourseDto update(@RequestBody CourseDto courseDto) {
        return service.updateCourse(courseDto);
    }
    @GetMapping("/find_by_name/{name}")
    public CourseDto findCourseByName(@PathVariable String name) {
        return service.findCourseByName(name);
    }
}
