package com.example.traningsystem.service.impl;

import com.example.traningsystem.dao.CourseRepository;
import com.example.traningsystem.dao.GroupRepository;
import com.example.traningsystem.dao.ScheduleRepository;
import com.example.traningsystem.dao.TeacherRepository;
import com.example.traningsystem.dto.schedule.CreateScheduleRequest;
import com.example.traningsystem.dto.schedule.ScheduleDto;
import com.example.traningsystem.exceptions.ExistException;
import com.example.traningsystem.exceptions.NotFoundException;
import com.example.traningsystem.mapper.ScheduleMapper;
import com.example.traningsystem.model.CourseEntity;
import com.example.traningsystem.model.GroupEntity;
import com.example.traningsystem.model.ScheduleEntity;
import com.example.traningsystem.model.TeacherEntity;
import com.example.traningsystem.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.security.InvalidParameterException;
import java.time.LocalDateTime;

@Transactional
@RequiredArgsConstructor
@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository repository;
    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final ScheduleMapper scheduleMapper;

    @Override
    public ScheduleDto addSchedule(CreateScheduleRequest scheduleRequest) {
        TeacherEntity teacher = teacherRepository.findById(scheduleRequest.getTeacherId())
                .orElseThrow(() -> new NotFoundException("TeacherEntity not found"));
        CourseEntity course = courseRepository.findById(scheduleRequest.getCourseId())
                .orElseThrow(() -> new NotFoundException("Course not found"));
        GroupEntity group = groupRepository.findById(scheduleRequest.getGroupId())
                .orElseThrow(() -> new NotFoundException("GroupEntity not found"));
        LocalDateTime scheduledTime = scheduleRequest.getScheduledTime();
        boolean existTeacherByDate = repository.existsByTeacherAndDate(teacher, scheduledTime);
        if (existTeacherByDate) {
            throw new ExistException("TeacherEntity teaching lesson");
        }
        boolean existsGroupByDate = repository.existsByGroupAndDate(group, scheduledTime);
        if (existsGroupByDate) {
            throw new ExistException("GroupEntity for lesson");
        }
        if (!teacher.getCourse().getId().equals(course.getId())) {
            throw new InvalidParameterException("TeacherEntity or Course not found");
        }
        ScheduleEntity schedule = new ScheduleEntity();
        schedule.setTeacher(teacher);
        schedule.setCourse(course);
        schedule.setGroup(group);
        schedule.setDate(scheduledTime);
        return scheduleMapper.toDto(repository.save(schedule));
    }

    @Override
    public ScheduleDto updateSchedule(CreateScheduleRequest requestSchedule) {
        CourseEntity course = courseRepository.findById(requestSchedule.getCourseId())
                .orElseThrow(() -> new NotFoundException("Course not found"));
        GroupEntity group = groupRepository.findById(requestSchedule.getGroupId())
                .orElseThrow(() -> new NotFoundException("GroupEntity not found"));
        TeacherEntity teacher = teacherRepository.findById(requestSchedule.getTeacherId())
                .orElseThrow(() -> new NotFoundException("TeacherEntity not found"));
        ScheduleEntity schedule = repository.findById(requestSchedule.getId())
                .orElseThrow(() -> new NotFoundException("ScheduleEntity not found"));

        LocalDateTime startDay = requestSchedule.getScheduledTime().toLocalDate().atStartOfDay();
        boolean existsTeacherToTime = repository.existsByTeacherAndDateAndId(teacher, startDay, schedule.getId());
        if (existsTeacherToTime) {
            throw new ExistException("TeacherEntity teaching lesson");
        }
        boolean existsGroupToTime = repository.existsByGroupAndDateAndId(group, startDay, schedule.getId());
        if (existsGroupToTime) {
            throw new ExistException("GroupEntity for lesson");
        }
        schedule.setCourse(course);
        schedule.setTeacher(teacher);
        schedule.setGroup(group);
        schedule.setDate(startDay);
        return scheduleMapper.toDto(repository.save(schedule));
    }

    @Override
    public void deleteSchedule(Long id) {
        ScheduleEntity schedule = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("ScheduleEntity not found"));
        repository.delete(schedule);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<ScheduleDto> getScheduleCourseForGroup(Pageable pageable, Long groupId) {
        if (!groupRepository.existsById(groupId)) {
            throw new NotFoundException("GroupEntity not found");
        }
        return repository.findAllByGroup_id(pageable, groupId)
                .map(scheduleMapper::toDto);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<ScheduleDto> getScheduleForTeacher(Pageable pageable, Long teacherId) {
        if (!teacherRepository.existsById(teacherId)) {
            throw new NotFoundException("TeacherEntity not found");
        }
        return repository.findAllByTeacher_id(pageable, teacherId)
                .map(scheduleMapper::toDto);
    }
}
