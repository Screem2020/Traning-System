package com.example.traningsystem.controller;

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
    public List<Teacher> findAll() {
        return service.findAllTeachers();
    }
    @PostMapping("/save_teacher")
    public void save(@RequestBody Teacher teacher) {
        service.save(teacher);
    }
    @PutMapping("/upadate_teacher")
    public Teacher updateTeacher(@RequestBody Teacher teacher) {
        return service.updateTeacher(teacher);
    }
    @PutMapping("/find_teacher/{id}")
    public  Teacher findTeacherById(@PathVariable Integer id) {
        return service.findTeacherById(id);
    }
    @DeleteMapping("/delete_teacher/{id}")
    public void deleteTeacherById(@PathVariable Integer id) {
        service.deleteTeacherById(id);
    }


}
