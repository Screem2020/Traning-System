package com.example.traningsystem.model;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "course")
@Entity
@Data
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long courseId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    private Teacher teacher;

}
