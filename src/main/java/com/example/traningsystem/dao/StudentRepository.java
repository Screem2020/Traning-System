package com.example.traningsystem.dao;

import com.example.traningsystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
        Student updateByStudent(Student student);
}
