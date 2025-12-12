package com.example.traningsystem.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;
    @OneToMany(mappedBy = "schedule")
    private List<Groups> groups;
    @OneToMany(mappedBy = "schedule")
    private List<Teacher> teacher;
    @OneToMany(mappedBy = "schedule")
    private List<Course> course;
    @Column
    private LocalDate date;
}
