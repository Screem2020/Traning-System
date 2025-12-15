package com.example.traningsystem.dto.teacher;

import com.example.traningsystem.model.Course;
import lombok.Data;

@Data
public class TeacherDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Course courseDto;
}
