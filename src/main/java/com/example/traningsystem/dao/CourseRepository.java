package com.example.traningsystem.dao;

import com.example.traningsystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
    Course findCourseByName(String name);
}
