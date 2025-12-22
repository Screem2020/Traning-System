package com.example.traningsystem.mapper;

import com.example.traningsystem.dto.group.CreateGroupRequest;
import com.example.traningsystem.dto.group.GroupDto;
import com.example.traningsystem.model.Group;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    GroupDto toDto(Group group);
    @Mapping(target = "students", ignore = true)
    @Mapping(target = "schedule", ignore = true)
    @Mapping(target = "groupCourses", ignore = true)
    Group toEntity(CreateGroupRequest groupRequest);
}
