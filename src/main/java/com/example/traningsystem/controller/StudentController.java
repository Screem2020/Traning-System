package com.example.traningsystem.controller;

import com.example.traningsystem.dto.student.CreateStudentRequest;
import com.example.traningsystem.dto.student.StudentDto;
import com.example.traningsystem.model.Student;
import com.example.traningsystem.service.ServiceStudent;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    public final ServiceStudent service;

    @PostMapping("/save")
    public void save(@RequestBody CreateStudentRequest student) {
        service.addStudent(student);
    }
    @PutMapping("/update")
    public Student update(@RequestBody CreateStudentRequest student) {
        return service.updateStudent(student);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStudent(id);
    }
    @GetMapping("/find/{id}")
    public Student findById(@PathVariable ("id") Long id) {
        return service.findStudentById(id);
    }
    @GetMapping()
    public List<StudentDto> findAllStudents() {
        return service.findAllStudents();
    }
}
