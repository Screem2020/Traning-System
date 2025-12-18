package com.example.traningsystem.dto.schedule;

import com.example.traningsystem.dto.course.CourseDto;
import com.example.traningsystem.dto.group.GroupDto;
import com.example.traningsystem.dto.teacher.TeacherDto;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ScheduleDto {
    private Long  scheduleId;
    private GroupDto group;
    private TeacherDto teacher;
    private CourseDto course;
    private LocalDateTime scheduledTime;
}
