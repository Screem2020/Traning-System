package com.example.traningsystem.controller;

import com.example.traningsystem.AbstractIntegrationTest;
import com.example.traningsystem.dao.TeacherRepository;
import com.example.traningsystem.model.TeacherEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

class TeacherControllerTest extends AbstractIntegrationTest {

    @Autowired
    TeacherRepository teacherRepository;

    @BeforeEach
    void setUp() {
        var teacher = new TeacherEntity();
        teacher.setFirstName("John");
        teacher.setLastName("Doe");
        TeacherEntity saveTeacher = teacherRepository.save(teacher);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void connectionEstablished() {
        assertThat(postgres.isRunning()).isTrue();
    }

    @Test
    void findAllTeachers() {
    }

    @Test
    void save() {

    }

    @Test
    void updateTeacher() {
    }

    @Test
    void findTeacherById() {
    }

    @Test
    void deleteTeacherById() {
    }
}