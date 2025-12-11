package com.example.traningsystem.controller;

import com.example.traningsystem.dto.student.CreateStudentRequest;
import com.example.traningsystem.dto.student.MergeStudentRequest;
import com.example.traningsystem.dto.student.StudentDto;
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

    @PostMapping("/save")
    public void saveStudent(@RequestBody CreateStudentRequest student) {
        service.addStudent(student);
    }
    @PutMapping("/update")
    public Student updateStudent(@RequestBody CreateStudentRequest student) {
        return service.updateStudent(student);
    }
    @DeleteMapping("/delete_student/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        service.deleteStudent(id);
    }
    @PutMapping("/merge")
    public void mergeStudentByGroup(@RequestBody MergeStudentRequest student) {
        service.mergeStudent(student);
    }
    @GetMapping("/find/{id}")
    public Student findStudentById(@PathVariable ("id") Integer id) {
        return service.findStudentById(id);
    }
    @GetMapping()
    public List<StudentDto> findAllStudents() {
        return service.findAllStudents();
    }
}
