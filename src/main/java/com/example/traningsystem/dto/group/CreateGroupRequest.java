package com.example.traningsystem.dto.group;

import com.example.traningsystem.dto.student.StudentDto;
import lombok.Data;
import java.util.List;

@Data
public class CreateGroupRequest {
    private Integer groupId;
    private String groupName;
    private List<StudentDto> students;
}
