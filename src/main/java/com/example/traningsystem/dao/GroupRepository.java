package com.example.traningsystem.dao;

import com.example.traningsystem.model.Group;
import com.example.traningsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Optional<Group> findByGroupName(String groupName);

    boolean existsByStudents(List<Student> students);
}
