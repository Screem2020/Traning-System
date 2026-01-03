package com.example.traningsystem.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "groups")
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "groups_id")
    private Long id;
    @Column(nullable = false)
    private String groupName;
    @OneToMany(mappedBy = "group")
    private List<StudentEntity> students;
    @OneToMany(mappedBy = "group")
    private List<ScheduleEntity> schedule;
    @OneToMany(mappedBy = "group")
    private List<GroupCourseEntity> groupCourse;
}
