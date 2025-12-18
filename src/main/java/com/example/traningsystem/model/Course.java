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
    @Column(name = "course_id", nullable = false)
    private Long courseId;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @OneToMany(mappedBy = "course",  cascade = CascadeType.ALL)
    private List<Schedule> schedule;
    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    private Teacher teacher;
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private List<GroupCourse>  groupCourse;

}
