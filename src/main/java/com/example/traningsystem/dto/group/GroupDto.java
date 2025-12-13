package com.example.traningsystem.dto.group;

import com.example.traningsystem.dto.student.StudentDto;
import com.example.traningsystem.model.Schedule;
import lombok.Data;
import java.util.List;

@Data
public class GroupDto {
    private Long groupId;
    private String groupName;
    private List<StudentDto> students;
    private Schedule schedule;
}
