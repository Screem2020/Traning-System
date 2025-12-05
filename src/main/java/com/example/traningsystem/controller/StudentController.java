package com.example.traningsystem.controller;

import com.example.traningsystem.model.Student;
import com.example.traningsystem.service.ServiceStudent;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentController {
    public final ServiceStudent service;

    @PostMapping("/save_student")
    public void saveStudent(@RequestBody Student student) {
        service.addStudent(student);
    }
    @PutMapping("/update_student")
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }
    @DeleteMapping("/delete_student/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        service.deleteStudent(id);
    }
    @PutMapping("/merge")
    public void mergeStudentByGroup(@RequestBody Student student) {
        service.mergeStudent(student);
    }
    @GetMapping("/{id}")
    public Student findStudentById(@PathVariable ("id") Integer id) {
        return service.findStudentById(id);
    }
    @GetMapping()
    public List<Student> findAllStudents() {
        return service.findAllStudents();
    }
}
