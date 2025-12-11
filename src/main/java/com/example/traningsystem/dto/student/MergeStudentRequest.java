package com.example.traningsystem.dto.student;

import com.example.traningsystem.model.Groups;
import lombok.Data;

@Data
public class MergeStudentRequest {

    private Integer id;
    private String firstName;
    private String lastName;
    private Groups group;
}
