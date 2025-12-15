package com.example.traningsystem.mapper;

import com.example.traningsystem.dto.course.CourseDto;
import com.example.traningsystem.dto.course.CreateCourseRequest;
import com.example.traningsystem.model.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    Course fromCreateRequest(CreateCourseRequest courseRequest);
    Course toEntity(CourseDto courseDto);
    CourseDto toDto(Course course);
}
