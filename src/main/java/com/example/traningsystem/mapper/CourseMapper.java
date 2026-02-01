package com.example.traningsystem.mapper;

import com.example.traningsystem.dto.course.CreateCourseRequest;
import com.example.traningsystem.model.CourseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(target = "teacher", ignore = true)
    CourseEntity toEntity(CreateCourseRequest courseRequest);
    CreateCourseRequest toDto(CourseEntity course);
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(CreateCourseRequest courseRequest, @MappingTarget CourseEntity course);
}
