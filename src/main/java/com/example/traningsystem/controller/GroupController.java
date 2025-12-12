package com.example.traningsystem.controller;

import com.example.traningsystem.dto.group.CreateGroupRequest;
import com.example.traningsystem.dto.group.GroupDto;
import com.example.traningsystem.model.Groups;
import com.example.traningsystem.service.ServiceGroups;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/groups")
@RequiredArgsConstructor
public class GroupController {

    public final ServiceGroups service;

    @PostMapping("/save")
    public void save(@RequestBody CreateGroupRequest group) {
        service.addGroup(group);
    }
    @GetMapping("/find/{id}")
    public Groups findById(@PathVariable Long id) {
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
    public Groups update(@RequestBody Groups group) {
        return service.updateGroup(group);
    }
    @DeleteMapping("/find_name/{groupName}")
    public Groups findGroupByName(@PathVariable String groupName) {
        return service.findByGroupName(groupName);
    }
    @DeleteMapping("delete_name/{groupName}")
    public void deleteByGroupName(@PathVariable String groupName) {
        service.deleteGroupByName(groupName);
    }
}
