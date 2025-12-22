package com.example.traningsystem.service;

import com.example.traningsystem.dto.group.CreateGroupRequest;
import com.example.traningsystem.dto.group.GroupDto;
import com.example.traningsystem.dto.student.StudentDto;
import java.util.List;

public interface ServiceGroups {
    GroupDto addGroup(CreateGroupRequest groupRequest);
    void deleteGroup(Long groupId);
    GroupDto findGroupById(Long groupId);
    GroupDto updateGroup(GroupDto group);
    List<GroupDto> findAllGroups();
    GroupDto findByGroupName(String groupName);
    void deleteGroupByName(String groupName);
    void deleteAllGroups();
    List<StudentDto> findAllStudents(Long groupId);
}
