package com.example.traningsystem.service;

import com.example.traningsystem.dto.group.CreateGroupRequest;
import com.example.traningsystem.dto.group.GroupDto;
import com.example.traningsystem.model.Groups;
import java.util.List;

public interface ServiceGroups {
    void  addGroup(CreateGroupRequest groupRequest);
    void deleteGroup(Long id);
    Groups findGroupById(Long id);
    Groups updateGroup(Groups group);
    List<GroupDto> findAllGroups();
    Groups findByGroupName(String groupName);
    void deleteGroupByName(String groupName);
}
