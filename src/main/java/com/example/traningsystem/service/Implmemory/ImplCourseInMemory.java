package com.example.traningsystem.service.Implmemory;

import com.example.traningsystem.dao.memory.CourseDao;
import com.example.traningsystem.model.Course;
import com.example.traningsystem.model.Teacher;
import com.example.traningsystem.service.ServiceCourse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ImplCourseInMemory implements ServiceCourse {

    private CourseDao repository;

    @Override
    public void saveCourse(Course course) {
        repository.saveCourse(course);
    }

    @Override
    public void deleteCourse(Integer id) {
        repository.deleteCourseById(id);
    }

    @Override
    public Course findCourseByName(String name) {
        return repository.findCourseByName(name);
    }

    @Override
    public Course updateCourse(Course course) {
        return repository.updateCourse(course);
    }

    @Override
    public void saveTeacher(Course course, Teacher teacher) {
        repository.saveTeacher(course);
    }

    @Override
    public Course findCourseById(Integer id) {
        return repository.findCourseById(id);
    }

    @Override
    public List<Course> findAllCourses() {
        return repository.findAllCourses();
    }
}
