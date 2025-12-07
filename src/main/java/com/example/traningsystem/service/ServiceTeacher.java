package com.example.traningsystem.service;

import com.example.traningsystem.model.Teacher;

import java.util.List;

public interface ServiceTeacher {
    void save(Teacher teacher);

    List<Teacher> findAllTeachers();

    Teacher findTeacherById(Integer id);

    void deleteTeacherById(Integer id);

    Teacher updateTeacher(Teacher teacher);
}