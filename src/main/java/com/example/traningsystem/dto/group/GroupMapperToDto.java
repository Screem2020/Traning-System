package com.example.traningsystem.dto.group;

import com.example.traningsystem.dto.student.StudentMapperToEntity;
import com.example.traningsystem.model.Groups;

public class GroupMapperToDto {
    public static GroupDto toEntity(Groups group) {
        GroupDto groupsDto = new GroupDto();
        groupsDto.setGroupName(group.getGroupName());
        groupsDto.setStudents(group.getStudents()
                .stream()
                .map(StudentMapperToEntity::toDto)
                .toList());
        return groupsDto;
    }
}
