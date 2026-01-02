package com.example.traningsystem.dto.student;

import com.example.traningsystem.model.GroupEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateStudentRequest {
    @NotNull
    private Long studentId;
    private String firstName;
    private String lastName;
    private Long groupId;
    private GroupEntity group;
}
