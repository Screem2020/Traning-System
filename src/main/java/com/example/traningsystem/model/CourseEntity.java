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
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String courseName;
    @Column(nullable = false)
    private String description;
    @OneToMany(mappedBy = "course")
    private List<ScheduleEntity> schedule;
    @OneToOne(mappedBy = "course")
    private TeacherEntity teacher;
    @OneToMany(mappedBy = "course")
    private List<GroupCourseEntity> groupCourse;
}
