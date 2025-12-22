package com.example.traningsystem.dto.group;

import com.example.traningsystem.dto.course.CourseDto;
import com.example.traningsystem.dto.schedule.ScheduleDto;
import com.example.traningsystem.dto.student.StudentDto;
import com.example.traningsystem.model.Schedule;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import java.util.List;

@Data
public class GroupDto {
    private Long groupId;
    private String groupName;
    private List<CourseDto> courses;
    private List<StudentDto> students;
    private List<ScheduleDto> schedules;
}
