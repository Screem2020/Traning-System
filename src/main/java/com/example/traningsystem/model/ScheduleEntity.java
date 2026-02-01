package com.example.traningsystem.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "schedule")
public class ScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "groups_id")
    private GroupEntity group;
    @ManyToOne()
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacher;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity course;
    @Column(name = "date", columnDefinition = "TIMESTAMP(0)")
    private LocalDateTime date;
}
