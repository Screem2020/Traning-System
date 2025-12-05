package com.example.traningsystem.controller;

import com.example.traningsystem.model.Groups;
import com.example.traningsystem.service.ServiceGroups;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/groups")
@AllArgsConstructor
public class GroupController {
    public final ServiceGroups service;
    @PostMapping("save_group")
    public void saveGroup(@RequestBody Groups group) {
        service.addGroup(group);
    }
    @GetMapping("/{id}")
    public  Groups findGroupById(@PathVariable Integer id) {
        return service.findGroupById(id);
    }
    @GetMapping()
    public List<Groups> findAllGroups() {
        return service.findAllGroups();
    }
    @DeleteMapping("DELETE /groups/{id}")
    public void deleteGroup(@RequestBody Integer id) {
        service.deleteGroup(id);
    }
    @PutMapping("update_group")
    public Groups updateGroup(@RequestBody Groups group) {
        return service.updateGroup(group);
    }
}
