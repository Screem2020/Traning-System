package com.example.traningsystem.dto.teacher;

import lombok.Data;

@Data
public class TeacherDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Long courseId;
}
