package com.example.traningsystem.dto.student;

import lombok.Data;

@Data
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Long groupId;
    private String groupName;
}