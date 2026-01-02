package com.example.traningsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "course")
@Entity
@Data
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String courseName;
    @Column(nullable = false)
    private String description;
    @OneToMany(mappedBy = "course",  cascade = CascadeType.ALL)
    private List<ScheduleEntity> schedule;
    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    private TeacherEntity teacher;
    @OneToMany(mappedBy = "course")
    private List<GroupCourseEntity> groupCourse;
}
