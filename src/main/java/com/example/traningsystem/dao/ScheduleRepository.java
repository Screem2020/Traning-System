package com.example.traningsystem.dao;

import com.example.traningsystem.model.Group;
import com.example.traningsystem.model.Schedule;
import com.example.traningsystem.model.Teacher;
import org.springframework.data.repository.CrudRepository;
import java.time.LocalDateTime;

public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
    boolean existsByTeacherAndDate(Teacher teacher, LocalDateTime date);
    boolean existsByGroupAndDate(Group group, LocalDateTime date);
    boolean existsByTeacherAndDateAndScheduleId(Teacher teacher, LocalDateTime date, Long scheduleId);
    boolean existsByGroupAndDateAndScheduleId(Group group, LocalDateTime date, Long scheduleId);
}
