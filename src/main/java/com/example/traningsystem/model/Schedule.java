package com.example.traningsystem.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;
    @ManyToOne
    @JoinColumn(name = "groups_id")
    private Group group;
    @ManyToOne()
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @Column(name = "date", columnDefinition = "TIMESTAMP(0)")
    private LocalDateTime date;
}
