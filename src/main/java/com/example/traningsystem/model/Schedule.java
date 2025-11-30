package com.example.traningsystem.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name = "group_id")
    private Groups groups;
    @OneToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @OneToOne
    @JoinColumn(name = "course_id")
    private Course course;
    @Column
    private LocalDate date;
}
