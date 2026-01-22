package com.example.traningsystem;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class AbstractIntegrationTest {

    @Container
    protected static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:14.4")
            .withDatabaseName("test_db")
            .withUsername("postgres")
            .withPassword("12345");

    @DynamicPropertySource
    static void registerDB(DynamicPropertyRegistry dynamicPropertyRegistrar) {
        dynamicPropertyRegistrar.add("spring.datasource.url", postgres::getJdbcUrl);
        dynamicPropertyRegistrar.add("spring.datasource.username", postgres::getUsername);
        dynamicPropertyRegistrar.add("spring.datasource.password", postgres::getPassword);
    }

    @LocalServerPort
    protected int port;

    protected String url(String path) {
        return "http://localhost:" + port + path;
    }
}