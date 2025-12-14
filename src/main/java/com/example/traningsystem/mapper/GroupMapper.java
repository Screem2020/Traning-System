package com.example.traningsystem.mapper;

import com.example.traningsystem.dto.group.GroupDto;
import com.example.traningsystem.model.Groups;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {StudentMapper.class})
public interface GroupMapper {
    @Mapping(target = "schedule", ignore = true)
    GroupDto toDto(Groups group);
    @Mapping(target = "schedule", ignore = true)
    Groups toEntity(GroupDto groupDto);
}
