package com.example.traningsystem.dto.course;

import lombok.Data;

@Data
public class CourseDto {
    private Long courseId;
    private String courseName;
    private String distraction;
    private Long teacherId;
}
