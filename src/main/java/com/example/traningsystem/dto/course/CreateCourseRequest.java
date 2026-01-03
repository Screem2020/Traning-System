package com.example.traningsystem.dto.course;

import com.example.traningsystem.dto.teacher.TeacherDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateCourseRequest {
    @NotNull
    private Long courseId;
    @Size(min = 3, max = 200)
    private String courseName;
    private String description;
    @NotNull
    private TeacherDto teacherDto;
}
