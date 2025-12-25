package com.example.traningsystem.controller;

import com.example.traningsystem.dto.teacher.CreateTeacherRequest;
import com.example.traningsystem.dto.teacher.TeacherDto;
import com.example.traningsystem.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    private final TeacherService service;

    @GetMapping
    public List<TeacherDto> findAll() {
        return service.findAllTeachers();
    }
    @PostMapping()
    public TeacherDto save(@RequestBody CreateTeacherRequest teacherRequest) {
        return service.addTeacher(teacherRequest);
    }
    @PutMapping()
    public TeacherDto updateTeacher(@RequestBody com.example.traningsystem.dto.teacher.TeacherDto teacherDto) {
        return service.updateTeacher(teacherDto);
    }
    @PutMapping("/{id}")
    public TeacherDto findTeacherById(@PathVariable Long id) {
        return service.findTeacherById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteTeacherById(@PathVariable Long id) {
        service.deleteTeacherById(id);
    }


}
