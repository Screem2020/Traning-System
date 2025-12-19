package com.example.traningsystem.service;

import com.example.traningsystem.dao.GroupRepository;
import com.example.traningsystem.dto.group.CreateGroupRequest;
import com.example.traningsystem.dto.group.GroupDto;
import com.example.traningsystem.exceptions.NotFoundException;
import com.example.traningsystem.mapper.GroupMapper;
import com.example.traningsystem.model.Group;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@AllArgsConstructor
@Service
public class GroupServiceImpl implements ServiceGroups {

    private final GroupRepository repository;
    private final GroupMapper groupMapper;

    @Override
    public GroupDto addGroup(CreateGroupRequest groupRequest) {
        Group group = new Group();
        group.setGroupName(groupRequest.getGroupName());
        Group save = repository.save(group);
        return groupMapper.toDto(save);
    }

    @Override
    public void deleteGroup(Long id) {
        repository.deleteById(id);
    }

    public GroupDto findGroupById(Long id) {
        Group group = repository.findById(id).orElseThrow(() -> new NotFoundException("Not found group with id " + id));
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
        repository.delete(group);
    }

    @Override
    public void deleteAllGroups() {
        repository.deleteAll();
    }
}
