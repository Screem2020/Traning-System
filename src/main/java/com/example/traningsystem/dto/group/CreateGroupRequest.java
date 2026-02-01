package com.example.traningsystem.dto.group;

import com.example.traningsystem.dto.student.StudentDto;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.List;

@Data
public class CreateGroupRequest {
    @Size(min = 3, max = 200)
    private String groupName;
    private List<StudentDto> students;
}
