package com.example.traningsystem.service;

import com.example.traningsystem.dto.teacher.CreateTeacherRequest;
import com.example.traningsystem.dto.teacher.TeacherDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherService {
    TeacherDto addTeacher(CreateTeacherRequest teacherRequest);
    Page<TeacherDto> findAllTeachers(Pageable pageable);
    TeacherDto findTeacherById(Long id);
    void deleteTeacherById(Long id);
    TeacherDto updateTeacher(Long id, TeacherDto teacherDto);
}