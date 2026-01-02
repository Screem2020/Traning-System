package com.example.traningsystem.dao;

import com.example.traningsystem.model.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<CourseEntity,Long> {
    Optional<CourseEntity>findByCourseName(String courseName);
}
