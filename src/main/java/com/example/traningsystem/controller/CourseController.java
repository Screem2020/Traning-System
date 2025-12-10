package com.example.traningsystem.controller;

import com.example.traningsystem.model.Course;
import com.example.traningsystem.model.Teacher;
import com.example.traningsystem.service.CourseServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/course")
@RestController
@AllArgsConstructor
public class CourseController {
    private final CourseServiceImpl service;
    @PostMapping("/course_save")
    public void saveCourse(@RequestBody Course course) {
        service.saveCourse(course);
    }
    @GetMapping
    public List<Course> allCourses() {
        return service.findAllCourses();
    }
    @GetMapping("/find_course/{id}")
    public Course findCourseById(@PathVariable Integer id) {
        return service.findCourseById(id);
    }
    @DeleteMapping("/delete_course/{id}")
    public void deleteCourseById(@PathVariable Integer id) {
        service.deleteCourse(id);
    }
    @PutMapping("/update_course")
    public Course upadateCourse(@RequestBody Course course) {
        return service.updateCourse(course);
    }
    @PostMapping("/save_course/teacher")
    public void saveTeacher(@RequestBody Course course, Teacher teacher) {
        service.saveTeacher(course, teacher);
    }
    @GetMapping("/find_by_name/{name}")
    public Course findCourseByName(@PathVariable String name) {
        return service.findCourseByName(name);
    }
}
