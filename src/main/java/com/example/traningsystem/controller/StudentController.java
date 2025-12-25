package com.example.traningsystem.controller;

import com.example.traningsystem.dto.student.CreateStudentRequest;
import com.example.traningsystem.dto.student.StudentDto;
import com.example.traningsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    public final StudentService service;

    @PostMapping()
    public StudentDto save(@RequestBody CreateStudentRequest student) {
        return service.addStudent(student);
    }
    @PutMapping()
    public StudentDto update(@RequestBody CreateStudentRequest student) {
        return service.updateStudent(student);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStudent(id);
    }
    @GetMapping("/{id}")
    public StudentDto findById(@PathVariable ("id") Long id) {
        return service.findStudentById(id);
    }
    @GetMapping()
    public List<StudentDto> findAllStudents() {
        return service.findAllStudents();
    }
}
