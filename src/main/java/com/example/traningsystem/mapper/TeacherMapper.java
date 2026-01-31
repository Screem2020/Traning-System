package com.example.traningsystem.mapper;

import com.example.traningsystem.dto.teacher.CreateTeacherRequest;
import com.example.traningsystem.dto.teacher.TeacherDto;
import com.example.traningsystem.model.TeacherEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TeacherMapper {
    @Mapping(target = "courseId", source = "course.id")
    TeacherDto toDto(TeacherEntity teacher);
    @Mapping(target = "course", ignore = true)
    TeacherEntity toEntity(CreateTeacherRequest teacherRequest);
}
