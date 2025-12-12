package com.example.traningsystem.service;

import com.example.traningsystem.model.Teacher;

import java.util.List;

public interface ServiceTeacher {
    void save(Teacher teacher);
    List<Teacher> findAllTeachers();
    Teacher findTeacherById(Long id);
    void deleteTeacherById(Long id);
    Teacher updateTeacher(Teacher teacher);
}