package com.example.traningsystem.service;

import com.example.traningsystem.dao.GroupRepository;
import com.example.traningsystem.dto.group.CreateGroupRequest;
import com.example.traningsystem.dto.group.GroupDto;
import com.example.traningsystem.exceptions.NotFoundException;
import com.example.traningsystem.mapper.GroupMapper;
import com.example.traningsystem.mapper.StudentMapper;
import com.example.traningsystem.model.Groups;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class GroupServiceImpl implements ServiceGroups {

    private final GroupRepository repository;
    private final StudentMapper studentMapper;
    private final GroupMapper groupMapper;

    @Override
    public void addGroup(CreateGroupRequest groupRequest) {
        Groups group = new Groups();
        group.setGroupName(groupRequest.getGroupName());
        group.setStudents(groupRequest.getStudents().stream()
                .map(studentMapper::toDto)
                .toList());
        repository.save(group);
    }

    @Override
    public void deleteGroup(Long id) {
        repository.deleteById(id);
    }

    public Groups findGroupById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Group not found with id " + id));
    }

    @Override
    public Groups updateGroup(Groups group) {
        Groups groupById = findGroupById(group.getGroupId());
        if (groupById != null) {
            groupById.setGroupName(groupById.getGroupName());
            groupById.setStudents(group.getStudents());
            return repository.save(groupById);
        }
        throw new NotFoundException("Group not found with id " + group.getGroupId());
    }

    @Override
    public List<GroupDto> findAllGroups() {
        return repository.findAll()
                .stream()
                .map(groupMapper::toDto)
                .toList();
    }

    @Override
    public Groups findByGroupName(String groupName) {
         return repository.findByGroupName(groupName);
    }

    @Override
    public void deleteGroupByName(String groupName) {
        Groups byGroupName = findByGroupName(groupName);
        if (byGroupName != null) {
            repository.deleteById(byGroupName.getGroupId());
        } throw new NotFoundException("Group not found with name " + groupName);
    }
}
