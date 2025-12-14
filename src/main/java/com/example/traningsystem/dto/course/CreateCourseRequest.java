package com.example.traningsystem.dto.course;

import lombok.Data;

@Data
public class CreateCourseRequest {
    private Long id;
    private String courseName;
    private String distraction;
}
