package com.example.traningsystem.service;

import com.example.traningsystem.dao.CourseRepository;
import com.example.traningsystem.dao.GroupRepository;
import com.example.traningsystem.dao.ScheduleRepository;
import com.example.traningsystem.dao.TeacherRepository;
import com.example.traningsystem.dto.schedule.CreateScheduleRequest;
import com.example.traningsystem.dto.schedule.ScheduleDto;
import com.example.traningsystem.exceptions.ExistException;
import com.example.traningsystem.exceptions.NotFoundException;
import com.example.traningsystem.mapper.ScheduleMapper;
import com.example.traningsystem.model.Course;
import com.example.traningsystem.model.Group;
import com.example.traningsystem.model.Schedule;
import com.example.traningsystem.model.Teacher;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Transactional
@Service
public class ScheduleServiceImpl implements ServiceSchedule{

    private final ScheduleRepository repository;
    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final ScheduleMapper scheduleMapper;

    @Override
    public ScheduleDto addSchedule(CreateScheduleRequest scheduleRequest) {
        Teacher teacher = teacherRepository.findById(scheduleRequest.getTeacherId())
                .orElseThrow(() -> new NotFoundException("Teacher not found"));
        Course course = courseRepository.findById(scheduleRequest.getCourseId())
                .orElseThrow(() -> new NotFoundException("Course not found"));
        Group group = groupRepository.findById(scheduleRequest.getGroupId())
                .orElseThrow(() -> new NotFoundException("Group not found"));
        LocalDateTime scheduledTime = scheduleRequest.getScheduledTime();
        boolean existTeacherByDate = repository.existsByTeacherAndDate(teacher, scheduledTime);
        if (existTeacherByDate) {
            throw new ExistException("Teacher teaching lesson");
        }
        boolean existsGroupByDate = repository.existsByGroupAndDate(group, scheduledTime);
        if (existsGroupByDate) {
            throw new ExistException("Group for lesson");
        }
        Schedule schedule = new Schedule();
        schedule.setTeacher(teacher);
        schedule.setCourse(course);
        schedule.setGroup(group);
        schedule.setDate(scheduledTime);
        return scheduleMapper.toDto(repository.save(schedule));
    }

    @Override
    public ScheduleDto updateSchedule(CreateScheduleRequest requestSchedule) {
        Course course = courseRepository.findById(requestSchedule.getCourseId())
                .orElseThrow(() -> new NotFoundException("Course not found"));
        Group group = groupRepository.findById(requestSchedule.getGroupId())
                .orElseThrow(() -> new NotFoundException("Group not found"));
        Teacher teacher = teacherRepository.findById(requestSchedule.getTeacherId())
                .orElseThrow(() -> new NotFoundException("Teacher not found"));
        Schedule schedule = repository.findById(requestSchedule.getScheduleId())
                .orElseThrow(() -> new NotFoundException("Schedule not found"));

        LocalDateTime startDay = requestSchedule.getScheduledTime().toLocalDate().atStartOfDay();
        boolean existsTeacherToTime = repository.existsByTeacherAndDateAndScheduleId(teacher, startDay, schedule.getScheduleId());
        if (existsTeacherToTime) {
            throw new ExistException("Teacher teaching lesson");
        }
        boolean existsGroupToTime = repository.existsByGroupAndDateAndScheduleId(group,  startDay, schedule.getScheduleId());
        if (existsGroupToTime) {
            throw new ExistException("Group for lesson");
        }
        schedule.setCourse(course);
        schedule.setTeacher(teacher);
        schedule.setGroup(group);
        schedule.setDate(startDay);
        return scheduleMapper.toDto(repository.save(schedule));
    }

    @Override
    public void deleteSchedule(ScheduleDto scheduleDto) {

    }

}
