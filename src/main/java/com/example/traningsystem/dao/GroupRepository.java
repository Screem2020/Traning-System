package com.example.traningsystem.dao;

import com.example.traningsystem.model.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface GroupRepository extends JpaRepository<GroupEntity, Long> {
    Optional<GroupEntity> findByGroupName(String groupName);
}
