package com.example.traningsystem.service;

import com.example.traningsystem.dto.teacher.CreateTeacherRequest;
import com.example.traningsystem.dto.teacher.TeacherDto;
import com.example.traningsystem.model.Teacher;

import java.util.List;

public interface ServiceTeacher {
    TeacherDto addTeacher(CreateTeacherRequest teacherRequest);
    List<TeacherDto> findAllTeachers();
    Teacher findTeacherById(Long id);
    void deleteTeacherById(Long id);
    Teacher updateTeacher(TeacherDto teacher);
}