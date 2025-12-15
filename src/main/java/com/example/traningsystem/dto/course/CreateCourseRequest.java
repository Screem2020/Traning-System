package com.example.traningsystem.dto.course;

import com.example.traningsystem.dto.teacher.TeacherDto;
import lombok.Data;

@Data
public class CreateCourseRequest {
    private Long id;
    private String courseName;
    private String distraction;
    private TeacherDto teacherDto;
}
