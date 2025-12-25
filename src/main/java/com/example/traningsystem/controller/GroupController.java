package com.example.traningsystem.controller;

import com.example.traningsystem.dto.group.CreateGroupRequest;
import com.example.traningsystem.dto.group.GroupDto;
import com.example.traningsystem.dto.student.StudentDto;
import com.example.traningsystem.service.GroupsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    public List<GroupDto> findAll() {
        return service.findAllGroups();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteGroup(id);
    }
    @PutMapping()
    public GroupDto update(@RequestBody GroupDto groupDto) {
        return service.updateGroup(groupDto);
    }
    @DeleteMapping("/{groupName}")
    public GroupDto findGroupByName(@PathVariable String groupName) {
        return service.findByGroupName(groupName);
    }
    @DeleteMapping("/{groupName}")
    public void deleteByGroupName(@PathVariable String groupName) {
        service.deleteGroupByName(groupName);
    }
    @DeleteMapping()
    public void deleteAllGroups() {
        service.deleteAllGroups();
    }
    @GetMapping("/{groupId}")
    public List<StudentDto> findAllStudents(@PathVariable Long groupId) {
        return service.findAllStudents(groupId);
    }
}
