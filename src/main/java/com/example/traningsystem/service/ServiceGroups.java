package com.example.traningsystem.service;

import com.example.traningsystem.dto.group.CreateGroupRequest;
import com.example.traningsystem.dto.group.GroupDto;
import com.example.traningsystem.model.Group;
import java.util.List;

public interface ServiceGroups {
    GroupDto addGroup(CreateGroupRequest groupRequest);
    void deleteGroup(Long groupId);
    Group findGroupById(Long groupId);
    Group updateGroup(Group group);
    List<GroupDto> findAllGroups();
    Group findByGroupName(String groupName);
    void deleteGroupByName(String groupName);
    void deleteAllGroups();
}
