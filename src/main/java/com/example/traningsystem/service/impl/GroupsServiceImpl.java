package com.example.traningsystem.service.impl;

import com.example.traningsystem.dao.GroupRepository;
import com.example.traningsystem.dao.StudentRepository;
import com.example.traningsystem.dto.group.CreateGroupRequest;
import com.example.traningsystem.dto.group.GroupDto;
import com.example.traningsystem.dto.student.StudentDto;
import com.example.traningsystem.exceptions.ExistStudentsInGroupException;
import com.example.traningsystem.exceptions.NotFoundException;
import com.example.traningsystem.mapper.GroupMapper;
import com.example.traningsystem.mapper.StudentMapper;
import com.example.traningsystem.model.Group;
import com.example.traningsystem.service.GroupsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class    GroupsServiceImpl implements GroupsService {

    private final GroupRepository repository;
    private final GroupMapper groupMapper;
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    @Transactional(readOnly = true)
    @Override
    public GroupDto addGroup(CreateGroupRequest groupRequest) {
        Group entity = groupMapper.toEntity(groupRequest);
        return groupMapper.toDto(repository.save(entity));
    }
    @Transactional(readOnly = true)
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
    @Transactional(readOnly = true)
    @Override
    public GroupDto updateGroup(GroupDto groupDto) {
        Group group = repository.findById(groupDto.getGroupId())
                .orElseThrow(() -> new NotFoundException("Group not found with id " + groupDto.getGroupId()));
        group.setGroupName(groupDto.getGroupName());
        return  groupMapper.toDto(repository.save(group));
    }

    @Override
    public Page<GroupDto> findAllGroups(Pageable pageable) {
        return repository.findAll(pageable).map(groupMapper::toDto);
    }

    @Override
    public GroupDto findGroupByName(String groupName) {
        return repository.findByGroupName(groupName)
                .map(groupMapper::toDto)
                .orElseThrow(() ->  new NotFoundException("Not found group with name " + groupName));
    }
    @Transactional(readOnly = true)
    @Override
    public void deleteByGroupName(String groupName) {
        Group group = repository.findByGroupName(groupName)
                .orElseThrow(() -> new NotFoundException("Not found group with name " + groupName));
        if (!group.getStudents().isEmpty()) {
            throw new ExistStudentsInGroupException("Group already exists in this group");
        }
        repository.delete(group);
    }
    @Transactional(readOnly = true)
    @Override
    public void deleteAllGroups() {
        repository.deleteAll();
    }

    @Override
    public Page<StudentDto> findAllStudentsByGroup(Pageable pageable, Long groupId) {
        return studentRepository.findAllByGroup_GroupId(pageable, groupId).map(studentMapper::toDto);
    }
}
