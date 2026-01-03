package com.example.traningsystem.dto.teacher;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateTeacherRequest {
    @NotNull
    private Long id;
    @Size(min = 3, max = 200)
    private String firstName;
    @Size(min = 3, max = 200)
    private String lastName;
    @NotNull
    private Long courseId;
}
