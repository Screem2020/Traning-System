package com.example.traningsystem.dao;

import com.example.traningsystem.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
    Page<Student> findAllByGroup_GroupId(Pageable pageable, Long groupId);
}
