package com.example.traningsystem.mapper;

import com.example.traningsystem.dto.group.CreateGroupRequest;
import com.example.traningsystem.dto.group.GroupDto;
import com.example.traningsystem.model.GroupEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    GroupDto toDto(GroupEntity group);
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "schedule", ignore = true)
    @Mapping(target = "groupCourse", ignore = true)
    GroupEntity toEntity(CreateGroupRequest groupRequest);
}
