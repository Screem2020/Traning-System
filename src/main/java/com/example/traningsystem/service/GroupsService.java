package com.example.traningsystem.service;

import com.example.traningsystem.dto.group.CreateGroupRequest;
import com.example.traningsystem.dto.group.GroupDto;
import com.example.traningsystem.dto.student.StudentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface GroupsService {
    GroupDto addGroup(CreateGroupRequest groupRequest);
    void deleteGroup(Long groupId);
    GroupDto findGroupById(Long groupId);
    GroupDto updateGroup(GroupDto group);
    Page<GroupDto> findAllGroups(Pageable pageable);
    GroupDto findGroupByName(String groupName);
    void deleteByGroupName(String groupName);
    void deleteAllGroups();
    Page<StudentDto> findAllStudentsByGroup(Pageable pageable, Long groupId);
}
