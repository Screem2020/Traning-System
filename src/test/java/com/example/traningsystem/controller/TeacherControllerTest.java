package com.example.traningsystem.controller;

import com.example.traningsystem.AbstractIntegrationTest;
import com.example.traningsystem.dao.CourseRepository;
import com.example.traningsystem.dao.TeacherRepository;
import com.example.traningsystem.factory.TestDataFactory;
import com.example.traningsystem.model.CourseEntity;
import com.example.traningsystem.model.TeacherEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

class TeacherControllerTest extends AbstractIntegrationTest {

    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    CourseRepository courseRepository;

    @BeforeEach
    void setUp() {
        courseRepository.deleteAll();
        teacherRepository.deleteAll();
    }

    @Test
    void connectionEstablished() {
        assertThat(postgres.isRunning()).isTrue();
    }

    @Test
    void findAllTeachers() {
        CourseEntity course = courseRepository.save(TestDataFactory.course());
        teacherRepository.save(TestDataFactory.teacher(course));


        var allTeacher = teacherRepository.findAll();

        assertThat(allTeacher).isNotEmpty();
        assertThat(allTeacher).hasSize(1);
        assertThat(allTeacher.get(0).getFirstName()).isEqualTo("test_teacher");
    }

    @Test
    void save() {
        CourseEntity course = courseRepository.save(TestDataFactory.course());
        teacherRepository.save(TestDataFactory.teacher(course));

        assertThat(teacherRepository.count()).isEqualTo(1);
        assertThat(teacherRepository.count()).isNotNull();
    }

    @Test
    void updateTeacher() {
        CourseEntity course = courseRepository.save(TestDataFactory.course());
        TeacherEntity teacher = teacherRepository.save(TestDataFactory.teacher(course));

        teacher.setLastName("updated_teacher");
        teacherRepository.save(teacher);
        TeacherEntity updateTeacher = teacherRepository.findById(teacher.getId()).orElseThrow();

        assertThat(updateTeacher.getLastName()).isEqualTo("updated_teacher");
    }

    @Test
    void findTeacherById() {
        CourseEntity course = courseRepository.save(TestDataFactory.course());
        TeacherEntity teacher = teacherRepository.save(TestDataFactory.teacher(course));

        TeacherEntity findTeacher = teacherRepository.findById(teacher.getId()).orElseThrow();

        assertThat(findTeacher.getLastName()).isEqualTo("test_teacher_desc");
    }

    @Test
    void deleteTeacherById() {
        CourseEntity course = courseRepository.save(TestDataFactory.course());
        TeacherEntity teacher = TestDataFactory.teacher(course);

        teacher.setCourse(course);
        course.setTeacher(teacher);

        teacherRepository.save(teacher);

        teacherRepository.deleteById(teacher.getId());

        assertThat(teacherRepository.findById(teacher.getId()).isEmpty());
    }
}