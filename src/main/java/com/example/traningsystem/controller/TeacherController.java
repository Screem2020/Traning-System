package com.example.traningsystem.controller;

import com.example.traningsystem.dto.teacher.CreateTeacherRequest;
import com.example.traningsystem.dto.teacher.TeacherDto;
import com.example.traningsystem.model.Teacher;
import com.example.traningsystem.service.ServiceTeacher;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    private final ServiceTeacher service;

    @GetMapping
    public List<TeacherDto> findAll() {
        return service.findAllTeachers();
    }
    @PostMapping("/save_teacher")
    public TeacherDto save(@RequestBody CreateTeacherRequest teacherRequest) {
        return service.addTeacher(teacherRequest);
    }
    @PutMapping("/upadate_teacher")
    public TeacherDto updateTeacher(@RequestBody com.example.traningsystem.dto.teacher.TeacherDto teacherDto) {
        return service.updateTeacher(teacherDto);
    }
    @PutMapping("/find_teacher/{id}")
    public TeacherDto findTeacherById(@PathVariable Long id) {
        return service.findTeacherById(id);
    }
    @DeleteMapping("/delete_teacher/{id}")
    public void deleteTeacherById(@PathVariable Long id) {
        service.deleteTeacherById(id);
    }


}
