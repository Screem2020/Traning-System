package com.example.traningsystem.controller;

import com.example.traningsystem.dao.CourseRepository;
import com.example.traningsystem.model.CourseEntity;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.junit.jupiter.Testcontainers;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
class TeacherControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CourseRepository courseRepository;

    @SneakyThrows
    @Test
    void findAll() {


        mockMvc.perform(get("/api/v1/teacher"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.content").isArray())
                .andExpect(jsonPath("$.content").isEmpty())
                .andReturn();
    }

    @SneakyThrows
    @Test
    void save() {
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseName("Java");
        courseEntity.setDescription("Java the Best");
        courseRepository.save(courseEntity);

        String teacherJson = """
                {
                "firstName":"Nina",
                "lastName":"Alekseevna",
                "courseId":%d
                }
                """.formatted(courseEntity.getId());

        mockMvc.perform(post("/api/v1/teacher")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(teacherJson))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Nina"))
                .andExpect(jsonPath("$.lastName").value("Alekseevna"))
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
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