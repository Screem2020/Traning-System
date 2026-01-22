package com.example.traningsystem.controller;

import com.example.traningsystem.dto.teacher.CreateTeacherRequest;
import com.example.traningsystem.dto.teacher.TeacherDto;
import com.example.traningsystem.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    private final TeacherService service;

    @GetMapping
    public Page<TeacherDto> findAll(
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = {"id", "firstName"},
                    direction = Sort.Direction.DESC
            )Pageable pageable) {
        return service.findAllTeachers(pageable);
    }
    @PostMapping()
    public TeacherDto save(@RequestBody CreateTeacherRequest teacherRequest) {
        return service.addTeacher(teacherRequest);
    }
    @PutMapping()
    public TeacherDto updateTeacher(@RequestBody TeacherDto teacherDto) {
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
