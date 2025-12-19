package com.example.traningsystem.controller;

import com.example.traningsystem.dto.group.CreateGroupRequest;
import com.example.traningsystem.dto.group.GroupDto;
import com.example.traningsystem.model.Group;
import com.example.traningsystem.service.ServiceGroups;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
@RequiredArgsConstructor
public class GroupController {

    public final ServiceGroups service;
    private final ServiceGroups serviceGroups;

    @PostMapping("/save")
    public GroupDto save(@RequestBody CreateGroupRequest groupRequest) {
        return serviceGroups.addGroup(groupRequest);
    }
    @GetMapping("/find/{id}")
    public GroupDto findById(@PathVariable Long id) {
        return service.findGroupById(id);
    }
    @GetMapping()
    public List<GroupDto> findAll() {
        return service.findAllGroups();
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteGroup(id);
    }
    @PutMapping("/update")
    public GroupDto update(@RequestBody GroupDto groupDto) {
        return service.updateGroup(groupDto);
    }
    @DeleteMapping("/find/name/{groupName}")
    public GroupDto findGroupByName(@PathVariable String groupName) {
        return service.findByGroupName(groupName);
    }
    @DeleteMapping("delete/name/{groupName}")
    public void deleteByGroupName(@PathVariable String groupName) {
        service.deleteGroupByName(groupName);
    }
    @DeleteMapping("delete/all")
    public void deleteAllGroups() {
        service.deleteAllGroups();
    }
}
