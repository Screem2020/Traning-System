package com.example.traningsystem.dao;

import com.example.traningsystem.model.GroupEntity;
import com.example.traningsystem.model.ScheduleEntity;
import com.example.traningsystem.model.TeacherEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import java.time.LocalDateTime;

public interface ScheduleRepository extends CrudRepository<ScheduleEntity, Long> {
    boolean existsByTeacherAndDate(TeacherEntity teacher, LocalDateTime date);
    boolean existsByGroupAndDate(GroupEntity group, LocalDateTime date);
    boolean existsByTeacherAndDateAndId(TeacherEntity teacher, LocalDateTime date, Long scheduleId);
    boolean existsByGroupAndDateAndId(GroupEntity group, LocalDateTime date, Long scheduleId);
    Page<ScheduleEntity> findAllByCourse_id(Pageable pageable, Long id);
    boolean existsById(Long id);
    Page<ScheduleEntity> findAllByTeacher_id(Pageable pageable, Long id);
    Page<ScheduleEntity> findAllByGroup_id(Pageable pageable, Long id);
}
