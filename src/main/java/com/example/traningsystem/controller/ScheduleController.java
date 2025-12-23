package com.example.traningsystem.controller;

import com.example.traningsystem.dto.schedule.CreateScheduleRequest;
import com.example.traningsystem.dto.schedule.ScheduleDto;
import com.example.traningsystem.service.ServiceSchedule;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ServiceSchedule service;

    @PostMapping("/save")
    public ScheduleDto save(@RequestBody CreateScheduleRequest schedule) {
        return service.addSchedule(schedule);
    }
    @PutMapping("/update")
    public ScheduleDto update(@RequestBody CreateScheduleRequest schedule) {
        return service.updateSchedule(schedule);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteSchedule(id);
    }
    @GetMapping("/list/course/{courseId}")
    public List<ScheduleDto> getScheduleByIdCourse(@PathVariable Long courseId) {
        return service.getScheduleForCourse(courseId);
    }
    @GetMapping("/list/group/{groupId}")
    public List<ScheduleDto> getScheduleCourseForGroupId(@PathVariable Long groupId) {
        return service.getScheduleCourseForGroup(groupId);
    }
    @GetMapping("/list/teacher/{teacherId}")
    public List<ScheduleDto> getScheduleForTeacher(@PathVariable Long teacherId) {
        return service.getScheduleForTeacher(teacherId);
    }
}

