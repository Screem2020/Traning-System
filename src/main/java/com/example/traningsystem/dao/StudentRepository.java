package com.example.traningsystem.dao;

import com.example.traningsystem.model.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity,Long> {
    Page<StudentEntity> findAllByGroup_id(Pageable pageable, Long id);
}
