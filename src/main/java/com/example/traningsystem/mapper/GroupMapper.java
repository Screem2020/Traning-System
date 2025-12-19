package com.example.traningsystem.mapper;

import com.example.traningsystem.dto.group.GroupDto;
import com.example.traningsystem.model.Group;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GroupMapper {
    GroupDto toDto(Group group);
}
