package com.example.traningsystem.mapper;

import com.example.traningsystem.dto.course.CourseRequest;
import com.example.traningsystem.model.Course;
import com.example.traningsystem.model.GroupCourse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(target = "teacher", ignore = true)
    Course toEntity(CourseRequest courseRequest);
    CourseRequest toDto(Course course);

//    default  CourseRequest mapGroupCourseToCourseRequest(GroupCourse groupCourse) {
//        if (groupCourse == null)
//            return null;
//        Course course = groupCourse.getCourse();
//        CourseRequest courseRequest = new CourseRequest();
//        courseRequest.setCourseId(course.getCourseId());
//        courseRequest.setCourseName(course.getCourseName());
//        return courseRequest;
//    }
}
