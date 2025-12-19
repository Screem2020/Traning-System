package com.example.traningsystem.mapper;

import com.example.traningsystem.dto.schedule.ScheduleDto;
import com.example.traningsystem.model.Schedule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {
    ScheduleDto toDto(Schedule schedule);
    Schedule toEntity(ScheduleDto scheduleDto);
}
