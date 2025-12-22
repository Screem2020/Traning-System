package com.example.traningsystem.mapper;

import com.example.traningsystem.dto.course.CourseDto;
import com.example.traningsystem.dto.course.CreateCourseRequest;
import com.example.traningsystem.model.Course;
import com.example.traningsystem.model.GroupCourse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(target = "teacher", ignore = true)
    Course toEntity(CreateCourseRequest courseRequest);
    Course toEntity(CourseDto courseDto);
    CourseDto toDto(Course course);

    default  CourseDto mapGroupCourseToCourseDto(GroupCourse groupCourse) {
        if (groupCourse == null)
            return null;
        Course course = groupCourse.getCourse();
        CourseDto courseDto = new CourseDto();
        courseDto.setCourseId(course.getCourseId());
        courseDto.setCourseName(course.getCourseName());
        return courseDto;
    }
}
