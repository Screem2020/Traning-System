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
import com.example.traningsystem.model.Course;
import com.example.traningsystem.model.Group;
import com.example.traningsystem.model.Schedule;
import com.example.traningsystem.model.Teacher;
import com.example.traningsystem.service.ScheduleService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.security.InvalidParameterException;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository repository;
    private final GroupRepository groupRepository;
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final ScheduleMapper scheduleMapper;

    @Transactional(readOnly = true)
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
        if (!teacher.getCourse().getCourseId().equals(course.getCourseId())) {
            throw new InvalidParameterException("Teacher or Course not found");
        }
        Schedule schedule = new Schedule();
        schedule.setTeacher(teacher);
        schedule.setCourse(course);
        schedule.setGroup(group);
        schedule.setDate(scheduledTime);
        return scheduleMapper.toDto(repository.save(schedule));
    }
    @Transactional(readOnly = true)
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
        boolean existsGroupToTime = repository.existsByGroupAndDateAndScheduleId(group, startDay, schedule.getScheduleId());
        if (existsGroupToTime) {
            throw new ExistException("Group for lesson");
        }
        schedule.setCourse(course);
        schedule.setTeacher(teacher);
        schedule.setGroup(group);
        schedule.setDate(startDay);
        return scheduleMapper.toDto(repository.save(schedule));
    }
    @Transactional(readOnly = true)
    @Override
    public void deleteSchedule(Long id) {
        Schedule schedule = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Schedule not found"));
        repository.delete(schedule);
    }

    @Override
    public Page<ScheduleDto> getScheduleForCourse(Pageable pageable, @NotNull Long courseId) {
        if (!courseRepository.existsById(courseId)) {
            throw new NotFoundException("Course not found");
        }
        return repository.findAllByCourse_CourseId(pageable, courseId)
                .map(scheduleMapper::toDto);
    }

    @Override
    public Page<ScheduleDto> getScheduleCourseForGroup(Pageable pageable, Long groupId) {
        if (!groupRepository.existsById(groupId)) {
            throw new NotFoundException("Group not found");
        }
        return repository.findAllByGroup_GroupId(pageable, groupId)
                .map(scheduleMapper::toDto);
    }

    @Override
    public Page<ScheduleDto> getScheduleForTeacher(Pageable pageable, Long teacherId) {
        if (!teacherRepository.existsById(teacherId)) {
            throw new NotFoundException("Teacher not found");
        }
        return repository.findAllByTeacher_TeacherId(pageable, teacherId)
                .map(scheduleMapper::toDto);
    }
}
