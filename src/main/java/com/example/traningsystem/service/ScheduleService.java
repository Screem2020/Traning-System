package com.example.traningsystem.service;

import com.example.traningsystem.dto.schedule.CreateScheduleRequest;
import com.example.traningsystem.dto.schedule.ScheduleDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ScheduleService {
    ScheduleDto addSchedule(CreateScheduleRequest scheduleRequest);
    ScheduleDto updateSchedule(CreateScheduleRequest scheduleRequest);
    void deleteSchedule(Long id);
    Page<ScheduleDto> getScheduleCourseForGroup(Pageable pageable, Long groupId);
    Page<ScheduleDto> getScheduleForTeacher(Pageable pageable,Long teacherId);
}
