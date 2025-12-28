package com.example.traningsystem.controller;

import com.example.traningsystem.dto.schedule.CreateScheduleRequest;
import com.example.traningsystem.dto.schedule.ScheduleDto;
import com.example.traningsystem.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

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
    public Page<ScheduleDto> getScheduleByIdCourse(
            @PathVariable Long courseId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id", "courseName"));
        return service.getScheduleForCourse(pageRequest, courseId);
    }
    @GetMapping("/{groupId}")
    public Page<ScheduleDto> getScheduleCourseForGroupId(
            @PathVariable Long groupId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id", "groupName"));
        return service.getScheduleCourseForGroup(pageRequest, groupId);
    }
    @GetMapping("/{teacherId}")
    public Page<ScheduleDto> getScheduleForTeacher(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @PathVariable Long teacherId) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "id", "teacherName"));
        return service.getScheduleForTeacher(pageRequest, teacherId);
    }
}

