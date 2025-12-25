package com.example.traningsystem.service;

import com.example.traningsystem.dao.GroupRepository;
import com.example.traningsystem.dto.group.CreateGroupRequest;
import com.example.traningsystem.dto.group.GroupDto;
import com.example.traningsystem.dto.student.StudentDto;
import com.example.traningsystem.exceptions.ExistStudentsInGroupException;
import com.example.traningsystem.exceptions.NotFoundException;
import com.example.traningsystem.mapper.GroupMapper;
import com.example.traningsystem.mapper.StudentMapper;
import com.example.traningsystem.model.Group;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@AllArgsConstructor
@Service
public class GroupsServiceImpl implements GroupsService {

    private final GroupRepository repository;
    private final GroupMapper groupMapper;
    private final StudentMapper studentMapper;

    @Override
    public GroupDto addGroup(CreateGroupRequest groupRequest) {
        Group entity = groupMapper.toEntity(groupRequest);
        return groupMapper.toDto(repository.save(entity));
    }

    @Override
    public void deleteGroup(Long id) {
        Group group = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Group not found"));
        if (!group.getStudents().isEmpty()) {
            throw new ExistStudentsInGroupException("Group already exists in this group");
        }
        repository.deleteById(id);
    }

    public GroupDto findGroupById(Long id) {
        Group group = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found group with id " + id));
        return groupMapper.toDto(group);
    }

    @Override
    public GroupDto updateGroup(GroupDto groupDto) {
        Group group = repository.findById(groupDto.getGroupId())
                .orElseThrow(() -> new NotFoundException("Group not found with id " + groupDto.getGroupId()));
        group.setGroupName(groupDto.getGroupName());
        return  groupMapper.toDto(repository.save(group));
    }

    @Override
    public List<GroupDto> findAllGroups() {
        return repository.findAll()
                .stream()
                .map(groupMapper::toDto)
                .toList();
    }

    @Override
    public GroupDto findByGroupName(String groupName) {
        return repository.findByGroupName(groupName)
                .map(groupMapper::toDto)
                .orElseThrow(() ->  new NotFoundException("Not found group with name " + groupName));
    }

    @Override
    public void deleteGroupByName(String groupName) {
        Group group = repository.findByGroupName(groupName)
                .orElseThrow(() -> new NotFoundException("Not found group with name " + groupName));
        if (!group.getStudents().isEmpty()) {
            throw new ExistStudentsInGroupException("Group already exists in this group");
        }
        repository.delete(group);
    }

    @Override
    public void deleteAllGroups() {
        repository.deleteAll();
    }

    @Override
    public List<StudentDto> findAllStudents(Long groupId) {
        Group group = repository.findById(groupId)
                .orElseThrow(() -> new NotFoundException("Not found group with id " + groupId));
        return group.getStudents().stream().map(studentMapper::toDto).toList();
    }
}
