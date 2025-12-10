package com.example.traningsystem.dao.memory;

import com.example.traningsystem.model.Course;
import com.example.traningsystem.model.Teacher;
import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Repository;

import java.util.List;

@Data
@Repository
public class CourseDao {
    private final List<Course> COURSES;

    public void saveCourse(Course course) {
        COURSES.add(course);
    }

    @SneakyThrows
    public Course findCourseById(Integer id) {
        return COURSES.stream()
                .filter(element -> element.getCourseId().equals(id))
                .findFirst()
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public void saveTeacher(Course course) {
        Teacher teacher = course.getTeacher();
        if (teacher != null) {
            teacher.setFirstName(teacher.getFirstName());
            teacher.setLastName(teacher.getLastName());
        } throw new NullPointerException();
    }

    @SneakyThrows
    public Course findCourseByName(String courseName) {
        return COURSES.stream()
                .filter(element -> element.getName().equals(courseName))
                .findFirst()
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    public Course updateCourse(Course course) {
        Course courseById = findCourseById(course.getCourseId());
        courseById.setName(course.getName());
        courseById.setDescription(course.getDescription());
        return courseById;
    }

    public void deleteCourseById(Integer id) {
        Course courseById = findCourseById(id);
        COURSES.remove(courseById);
    }
}
