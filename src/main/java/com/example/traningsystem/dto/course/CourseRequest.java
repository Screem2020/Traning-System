package com.example.traningsystem.dto.course;

import com.example.traningsystem.dto.teacher.TeacherDto;
import lombok.Data;

@Data
public class CourseRequest {
    private Long courseId;
    private String courseName;
    private String description;
    private TeacherDto teacherDto;
}
