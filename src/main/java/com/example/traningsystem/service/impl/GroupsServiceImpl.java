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
import com.example.traningsystem.model.GroupEntity;
import com.example.traningsystem.service.GroupsService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class    GroupsServiceImpl implements GroupsService {

    private final GroupRepository repository;
    private final GroupMapper groupMapper;
    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    @Override
    public GroupDto addGroup(CreateGroupRequest groupRequest) {
        GroupEntity entity = groupMapper.toEntity(groupRequest);
        return groupMapper.toDto(repository.save(entity));
    }

    @Override
    public void deleteGroup(Long id) {
        GroupEntity group = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("GroupEntity not found"));
        if (!group.getStudents().isEmpty()) {
            throw new ExistStudentsInGroupException("GroupEntity already exists in this group");
        }
        repository.deleteById(id);
    }
    @Transactional(readOnly = true)
    public GroupDto findGroupById(Long id) {
        GroupEntity group = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found group with id " + id));
        return groupMapper.toDto(group);
    }

    @Override
    public GroupDto updateGroup(GroupDto groupDto) {
        GroupEntity group = repository.findById(groupDto.getId())
                .orElseThrow(() -> new NotFoundException("GroupEntity not found with id " + groupDto.getId()));
        group.setGroupName(groupDto.getGroupName());
        return  groupMapper.toDto(repository.save(group));
    }
    @Transactional(readOnly = true)
    @Override
    public Page<GroupDto> findAllGroups(Pageable pageable) {
        return repository.findAll(pageable).map(groupMapper::toDto);
    }
    @Transactional(readOnly = true)
    @Override
    public GroupDto findGroupByName(String groupName) {
        return repository.findByGroupName(groupName)
                .map(groupMapper::toDto)
                .orElseThrow(() ->  new NotFoundException("Not found group with name " + groupName));
    }

    @Override
    public void deleteByGroupName(String groupName) {
        GroupEntity group = repository.findByGroupName(groupName)
                .orElseThrow(() -> new NotFoundException("Not found group with name " + groupName));
        if (!group.getStudents().isEmpty()) {
            throw new ExistStudentsInGroupException("GroupEntity already exists in this group");
        }
        repository.delete(group);
    }

    @Override
    public void deleteAllGroups() {
        repository.deleteAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Page<StudentDto> findAllStudentsByGroup(Pageable pageable, Long groupId) {
        return studentRepository.findAllByGroup_id(pageable, groupId).map(studentMapper::toDto);
    }
}
