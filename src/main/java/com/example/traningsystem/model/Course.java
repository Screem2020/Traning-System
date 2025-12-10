package com.example.traningsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Table(name = "course")
@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer courseId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
    @OneToOne(mappedBy = "course")
    private Teacher teacher;

}
