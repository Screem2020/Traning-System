package com.example.traningsystem.dao;

import com.example.traningsystem.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Long> {
    Group findByGroupName(String groupName);
}
