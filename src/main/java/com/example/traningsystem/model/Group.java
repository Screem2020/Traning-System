package com.example.traningsystem.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "groups")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "groups_id")
    private Long groupId;
    @Column(nullable = false)

    private String groupName;
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Student> students;
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Schedule> schedule;
    @OneToMany(mappedBy = "group",  cascade = CascadeType.ALL)
    private List<GroupCourse> groupCourses;
    }
