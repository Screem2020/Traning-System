package com.example.traningsystem.controller;

import com.example.traningsystem.dto.group.CreateGroupRequest;
import com.example.traningsystem.dto.group.GroupDto;
import com.example.traningsystem.dto.student.StudentDto;
import com.example.traningsystem.service.GroupsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/groups")
@RequiredArgsConstructor
public class GroupController {

    public final GroupsService service;

    @PostMapping()
    public GroupDto save(@RequestBody CreateGroupRequest groupRequest) {
        return service.addGroup(groupRequest);
    }
    @GetMapping("/{id}")
    public GroupDto findById(@PathVariable Long id) {
        return service.findGroupById(id);
    }
    @GetMapping()
    public Page<GroupDto> findAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
            ) {
        PageRequest pageRequest = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "groupName","groupId"));
        return service.findAllGroups(pageRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteGroup(id);
    }
    @PutMapping()
    public GroupDto update(@RequestBody GroupDto groupDto) {
        return service.updateGroup(groupDto);
    }
    @GetMapping("/{groupName}")
    public GroupDto findGroupByName(@PathVariable String groupName) {
        return service.findGroupByName(groupName);
    }
    @DeleteMapping("/{groupName}")
    public void deleteByGroupName(@PathVariable String groupName) {
        service.deleteByGroupName(groupName);
    }
    @DeleteMapping()
    public void deleteAllGroups() {
        service.deleteAllGroups();
    }
    @GetMapping("/{groupId}")
    public Page<StudentDto> findAll(
            @PathVariable Long groupId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Sort studentId = Sort.by(Sort.Direction.DESC, "studentId");
        PageRequest pageRequest = PageRequest.of(page, size, studentId);
        return service.findAllStudentsByGroup(pageRequest,groupId);
    }
}
