package com.example.traningsystem.factory;

import com.example.traningsystem.model.CourseEntity;
import com.example.traningsystem.model.TeacherEntity;

public class TestDataFactory {

    public static CourseEntity course() {
        CourseEntity course = new CourseEntity();
        course.setCourseName("test_course");
        course.setDescription("test_course_desc");
        return course;
    }

    public static TeacherEntity teacher(CourseEntity course) {
        TeacherEntity teacher = new TeacherEntity();
        teacher.setFirstName("test_teacher");
        teacher.setLastName("test_teacher_desc");
        teacher.setCourse(course);
        return teacher;
    }
}
