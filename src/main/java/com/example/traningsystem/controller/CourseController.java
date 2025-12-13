package com.example.traningsystem.controller;

import com.example.traningsystem.model.Course;
import com.example.traningsystem.model.Teacher;
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
    public void save(@RequestBody Course course) {
        service.saveCourse(course);
    }
    @GetMapping
    public List<Course> allCourses() {
        return service.findAllCourses();
    }
    @GetMapping("/find_course/{id}")
    public Course findById(@PathVariable Long id) {
        return service.findCourseById(id);
    }
    @DeleteMapping("/delete_course/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteCourse(id);
    }
    @PutMapping("/update_course")
    public Course update(@RequestBody Course course) {
        return service.updateCourse(course);
    }
    @GetMapping("/find_by_name/{name}")
    public Course findCourseByName(@PathVariable String name) {
        return service.findCourseByName(name);
    }
}
