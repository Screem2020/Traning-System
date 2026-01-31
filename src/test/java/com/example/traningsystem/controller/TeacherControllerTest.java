package com.example.traningsystem.controller;

import com.example.traningsystem.AbstractIntegrationTest;
import com.example.traningsystem.dao.CourseRepository;
import com.example.traningsystem.dao.TeacherRepository;
import com.example.traningsystem.dto.teacher.CreateTeacherRequest;
import com.example.traningsystem.dto.teacher.TeacherDto;
import com.example.traningsystem.factory.TestDataFactory;
import com.example.traningsystem.model.CourseEntity;
import com.example.traningsystem.model.TeacherEntity;
import com.example.traningsystem.utill.RestResponsePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.assertj.core.api.Assertions.assertThat;

class TeacherControllerTest extends AbstractIntegrationTest {

    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    TestRestTemplate restTemplate;

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

        ResponseEntity<RestResponsePage<TeacherDto>> response =  restTemplate.exchange("/api/v1/teacher/",
                HttpMethod.GET, null, new ParameterizedTypeReference<RestResponsePage<TeacherDto>>() {
        });

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        RestResponsePage<TeacherDto> result = response.getBody();

        Assertions.assertNotNull(result);
        assertThat(result).isNotEmpty();
        assertThat(result).isNotNull();
    }

    @Test
    void save() {
        CourseEntity course = courseRepository.save(TestDataFactory.course());

        CreateTeacherRequest teacherDto = new CreateTeacherRequest();
        teacherDto.setFirstName("test_teacher_created");
        teacherDto.setLastName("test_teacher");
        teacherDto.setCourseId(course.getId());

        HttpEntity<CreateTeacherRequest> request = new HttpEntity<>(teacherDto);

        ResponseEntity<CreateTeacherRequest> response = restTemplate.exchange("/api/v1/teacher/",
                HttpMethod.POST, request, CreateTeacherRequest.class);

        CreateTeacherRequest result = response.getBody();

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Assertions.assertNotNull(result);
        assertThat(result.getFirstName()).isEqualTo("test_teacher_created");
        assertThat(result.getLastName()).isEqualTo("test_teacher");
        assertThat(result.getCourseId()).isEqualTo(course.getId());
    }

    @Test
    void updateTeacher() {
        CourseEntity course = courseRepository.save(TestDataFactory.course());
        TeacherEntity teacher = teacherRepository.save(TestDataFactory.teacher(course));

        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setFirstName("test_update_teacher");
        HttpEntity<TeacherDto> request = new HttpEntity<>(teacherDto);

        ResponseEntity<TeacherDto> response = restTemplate.exchange("/api/v1/teacher/" + teacher.getId(),
                HttpMethod.PATCH, request, TeacherDto.class);

        TeacherDto result = response.getBody();

        assertThat(result).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        Assertions.assertNotNull(result);
        assertThat(result.getFirstName()).isEqualTo("test_update_teacher");
        assertThat(result.getLastName()).isEqualTo("test_teacher_desc");
    }

    @Test
    void findTeacherById() {
        CourseEntity course = courseRepository.save(TestDataFactory.course());
        TeacherEntity teacher = teacherRepository.save(TestDataFactory.teacher(course));

        ResponseEntity<TeacherDto> response = restTemplate.exchange("/api/v1/teacher/" + teacher.getId(),
                HttpMethod.GET, null, TeacherDto.class, teacher.getId());

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        TeacherDto teacherDto = response.getBody();
        System.out.println(teacherDto);

        Assertions.assertNotNull(teacherDto);
        assertThat(teacherDto.getId()).isEqualTo(teacher.getId());
        assertThat(teacherDto.getCourseId()).isNotNull();
        assertThat(teacherDto.getCourseId()).isEqualTo(course.getId());
        assertThat(teacherDto.getFirstName()).isEqualTo("test_teacher");

    }

    @Test
    void deleteTeacherById() {
        CourseEntity course = courseRepository.save(TestDataFactory.course());
        TeacherEntity teacher = teacherRepository.save(TestDataFactory.teacher(course));

        ResponseEntity<Void> response = restTemplate.exchange("/api/v1/teacher/" + teacher.getId(),
                HttpMethod.DELETE, null, Void.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        assertThat(teacherRepository.findById(teacher.getId()).isEmpty());
    }
}