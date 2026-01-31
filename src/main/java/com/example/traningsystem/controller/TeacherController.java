package com.example.traningsystem.controller;

import com.example.traningsystem.dto.teacher.CreateTeacherRequest;
import com.example.traningsystem.dto.teacher.TeacherDto;
import com.example.traningsystem.service.TeacherService;
import com.example.traningsystem.utill.PageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/teacher/")
public class TeacherController {

    private final TeacherService service;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public PageResponse<TeacherDto> findAll(
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = {"id", "firstName"},
                    direction = Sort.Direction.DESC
            )Pageable pageable) {
        Page<TeacherDto> allTeachers = service.findAllTeachers(pageable);
        return new PageResponse<>(
                allTeachers.getContent(),
                allTeachers.getNumber(),
                allTeachers.getSize(),
                allTeachers.getTotalElements(),
                allTeachers.getTotalPages(),
                allTeachers.isLast()
        );
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public TeacherDto save(@RequestBody CreateTeacherRequest teacherRequest) {
        return service.addTeacher(teacherRequest);
    }
    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeacherDto updateTeacher(@PathVariable Long id, @RequestBody TeacherDto teacherDto) {
        return service.updateTeacher(id, teacherDto);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TeacherDto findTeacherById(@PathVariable Long id) {
        return service.findTeacherById(id);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeacherById(@PathVariable Long id) {
        service.deleteTeacherById(id);
    }
}
