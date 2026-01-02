package com.example.traningsystem.mapper;

import com.example.traningsystem.dto.schedule.CreateScheduleRequest;
import com.example.traningsystem.dto.schedule.ScheduleDto;
import com.example.traningsystem.model.ScheduleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {
    ScheduleDto toDto(ScheduleEntity schedule);
    ScheduleEntity toEntity(ScheduleDto scheduleDto);
    ScheduleEntity toEntity(CreateScheduleRequest scheduleRequest);
}
