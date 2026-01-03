package com.example.traningsystem.dto.group;

import com.example.traningsystem.dto.course.CreateCourseRequest;
import com.example.traningsystem.dto.schedule.ScheduleDto;
import com.example.traningsystem.dto.student.StudentDto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import java.util.List;

@Data
public class GroupDto {
    @NotNull
    private Long groupId;
    @Size(min = 3, max = 200)
    private String groupName;
    private List<CreateCourseRequest> courses;
    private List<StudentDto> students;
    private List<ScheduleDto> schedules;
}
