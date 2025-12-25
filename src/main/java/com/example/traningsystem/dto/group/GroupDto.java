package com.example.traningsystem.dto.group;

import com.example.traningsystem.dto.course.CourseRequest;
import com.example.traningsystem.dto.schedule.ScheduleDto;
import com.example.traningsystem.dto.student.StudentDto;
import lombok.Data;
import java.util.List;

@Data
public class GroupDto {
    private Long groupId;
    private String groupName;
    private List<CourseRequest> courses;
    private List<StudentDto> students;
    private List<ScheduleDto> schedules;
}
