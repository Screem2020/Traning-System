package com.example.traningsystem.mapper;

import com.example.traningsystem.dto.teacher.CreateTeacherRequest;
import com.example.traningsystem.dto.teacher.TeacherDto;
import com.example.traningsystem.model.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    TeacherDto toDto(Teacher teacher);
    @Mapping(target = "course", ignore = true)
    Teacher toEntity(CreateTeacherRequest teacherRequest);
    Teacher toEntity(TeacherDto teacherDto);
}
