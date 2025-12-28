package com.example.traningsystem.dao;

import com.example.traningsystem.model.Group;
import com.example.traningsystem.model.Schedule;
import com.example.traningsystem.model.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import java.time.LocalDateTime;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
    boolean existsByTeacherAndDate(Teacher teacher, LocalDateTime date);
    boolean existsByGroupAndDate(Group group, LocalDateTime date);
    boolean existsByTeacherAndDateAndScheduleId(Teacher teacher, LocalDateTime date, Long scheduleId);
    boolean existsByGroupAndDateAndScheduleId(Group group, LocalDateTime date, Long scheduleId);
    Page<Schedule> findAllByCourse_CourseId(Pageable pageable, Long courseCourseId);
    boolean existsById(Long courseId);
    Page<Schedule> findAllByTeacher_TeacherId(Pageable pageable, Long teacherId);
    Page<Schedule> findAllByGroup_GroupId(Pageable pageable, Long groupId);
}
