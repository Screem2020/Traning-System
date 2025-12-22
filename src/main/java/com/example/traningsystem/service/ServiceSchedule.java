package com.example.traningsystem.service;

import com.example.traningsystem.dto.schedule.CreateScheduleRequest;
import com.example.traningsystem.dto.schedule.ScheduleDto;
import java.util.List;

public interface ServiceSchedule {
    ScheduleDto addSchedule(CreateScheduleRequest scheduleRequest);
    ScheduleDto updateSchedule(CreateScheduleRequest scheduleRequest);
    void deleteSchedule(Long id);
    List<ScheduleDto> getScheduleForCourse(Long courseId);
    ScheduleDto getScheduleForId(Long id);
    List<ScheduleDto> getScheduleCourseForGroup(Long groupId);
    List<ScheduleDto> getScheduleForTeacher(Long teacherId);
}
