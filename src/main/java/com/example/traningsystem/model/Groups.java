package com.example.traningsystem.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "groups")
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groups_id")
    private Long groupId;
    @Column(nullable = false)
    private String groupName;
    @OneToMany(mappedBy = "group")
    private List<Student> students;
    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;
    }
