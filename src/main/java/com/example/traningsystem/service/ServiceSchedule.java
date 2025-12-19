package com.example.traningsystem.service;

import com.example.traningsystem.dto.schedule.CreateScheduleRequest;
import com.example.traningsystem.dto.schedule.ScheduleDto;

public interface ServiceSchedule {
    ScheduleDto addSchedule(CreateScheduleRequest scheduleRequest);
    ScheduleDto updateSchedule(CreateScheduleRequest scheduleRequest);
}
