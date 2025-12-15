package com.example.traningsystem.dto.student;

import com.example.traningsystem.model.Group;
import lombok.Data;

@Data
public class StudentDto {

    private Long studentId;
    private String firstName;
    private String lastName;
    private Group groupDto;
}