package com.example.traningsystem.dto.course;

import com.example.traningsystem.model.Teacher;
import lombok.Data;

@Data
public class CourseDto {
    private Long courseId;
    private String courseName;
    private String distraction;
    private Teacher teacher;
}
