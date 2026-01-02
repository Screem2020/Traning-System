package com.example.traningsystem.controller;

import com.example.traningsystem.dto.schedule.CreateScheduleRequest;
import com.example.traningsystem.dto.schedule.ScheduleDto;
import com.example.traningsystem.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = {"id", "courseName"},
                    direction = Sort.Direction.DESC
            ) Pageable pageable) {
        return service.getScheduleCourseForGroup(pageable, courseId);
    }
    @GetMapping("/{groupId}")
    public Page<ScheduleDto> getScheduleCourseForGroupId(
            @PathVariable Long groupId,
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = {"id", "groupName"},
                    direction = Sort.Direction.DESC
            ) Pageable pageable) {
        return service.getScheduleCourseForGroup(pageable, groupId);
    }
    @GetMapping("/{teacherId}")
    public Page<ScheduleDto> getScheduleForTeacher(
            @PathVariable Long teacherId,
            @PageableDefault(
                    page = 0,
                    size = 10,
                    sort = {"id", "firstName"},
                    direction = Sort.Direction.DESC
            ) Pageable pageable) {
        return service.getScheduleForTeacher(pageable, teacherId);
    }
}

