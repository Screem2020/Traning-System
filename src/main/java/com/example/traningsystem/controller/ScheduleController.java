package com.example.traningsystem.controller;

import com.example.traningsystem.dto.schedule.CreateScheduleRequest;
import com.example.traningsystem.dto.schedule.ScheduleDto;
import com.example.traningsystem.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/schedule")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService service;

    @PostMapping()
    public ScheduleDto save(@RequestBody CreateScheduleRequest schedule) {
        return service.addSchedule(schedule);
    }
    @PutMapping()
    public ScheduleDto update(@RequestBody CreateScheduleRequest schedule) {
        return service.updateSchedule(schedule);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteSchedule(id);
    }
    @GetMapping("/{courseId}")
    public List<ScheduleDto> getScheduleByIdCourse(@PathVariable Long courseId) {
        return service.getScheduleForCourse(courseId);
    }
    @GetMapping("/{groupId}")
    public List<ScheduleDto> getScheduleCourseForGroupId(@PathVariable Long groupId) {
        return service.getScheduleCourseForGroup(groupId);
    }
    @GetMapping("/{teacherId}")
    public List<ScheduleDto> getScheduleForTeacher(@PathVariable Long teacherId) {
        return service.getScheduleForTeacher(teacherId);
    }
}

