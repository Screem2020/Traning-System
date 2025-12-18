package com.example.traningsystem.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id",  nullable = false)
    private Long teacherId;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @OneToMany(mappedBy = "teacher",  cascade = CascadeType.ALL)
    private List<Schedule> schedule;
    @OneToOne
    @JoinColumn(name = "course_id",  nullable = false)
    private Course course;
}
