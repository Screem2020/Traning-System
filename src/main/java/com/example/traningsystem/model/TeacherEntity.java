package com.example.traningsystem.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "teacher")
public class TeacherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @OneToMany(mappedBy = "teacher")
    private List<ScheduleEntity> schedule;
    @OneToOne
    @JoinColumn(name = "course_id",  nullable = false)
    private CourseEntity course;
}
