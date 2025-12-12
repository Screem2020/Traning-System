package com.example.traningsystem.dto.student;

import lombok.Data;

@Data
public class CreateStudentRequest {

    private String firstName;
    private String lastName;
    private Long groupId;
    private String groupName;
}
