package com.example.traningsystem.service;

import com.example.traningsystem.dto.teacher.CreateTeacherRequest;
import com.example.traningsystem.dto.teacher.TeacherDto;

import java.util.List;

public interface ServiceTeacher {
    TeacherDto addTeacher(CreateTeacherRequest teacherRequest);
    List<TeacherDto> findAllTeachers();
    TeacherDto findTeacherById(Long id);
    void deleteTeacherById(Long id);
    TeacherDto updateTeacher(TeacherDto teacherDto);
}