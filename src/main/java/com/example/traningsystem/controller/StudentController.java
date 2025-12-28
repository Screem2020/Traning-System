package com.example.traningsystem.controller;

import com.example.traningsystem.dto.student.CreateStudentRequest;
import com.example.traningsystem.dto.student.StudentDto;
import com.example.traningsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

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
    public Page<StudentDto> findAllStudents(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "firstName"));
        return  service.findAllStudents(pageRequest);
    }
}
