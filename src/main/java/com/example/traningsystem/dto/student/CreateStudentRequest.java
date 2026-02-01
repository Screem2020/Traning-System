package com.example.traningsystem.dto.student;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateStudentRequest {
    @NotNull
    private Long id;
    @Size(min = 3, max = 200)
    private String firstName;
    @Size(min = 3, max = 200)
    private String lastName;
    @NotNull
    private Long groupId;
}
