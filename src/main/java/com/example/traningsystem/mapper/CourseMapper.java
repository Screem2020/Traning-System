package com.example.traningsystem.mapper;

import com.example.traningsystem.dto.course.CourseRequest;
import com.example.traningsystem.model.Course;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(target = "teacher", ignore = true)
    Course toEntity(CourseRequest courseRequest);
    CourseRequest toDto(Course course);
    @Mapping(target = "courseId", ignore = true)
    void updateEntityFromDto(CourseRequest courseRequest, @MappingTarget Course course);
}
