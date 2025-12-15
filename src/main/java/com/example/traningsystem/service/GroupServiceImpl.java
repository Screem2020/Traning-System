package com.example.traningsystem.service;

import com.example.traningsystem.dao.GroupRepository;
import com.example.traningsystem.dao.StudentRepository;
import com.example.traningsystem.dto.group.CreateGroupRequest;
import com.example.traningsystem.dto.group.GroupDto;
import com.example.traningsystem.exceptions.NotFoundException;
import com.example.traningsystem.mapper.GroupMapper;
import com.example.traningsystem.mapper.StudentMapper;
import com.example.traningsystem.model.Group;
import com.example.traningsystem.model.Student;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@AllArgsConstructor
@Service
public class GroupServiceImpl implements ServiceGroups {

    private final GroupRepository repository;
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;
    private final GroupMapper groupMapper;

    @Override
    public GroupDto addGroup(CreateGroupRequest groupRequest) {
        Group group = new Group();
        group.setGroupName(groupRequest.getGroupName());
        group.setStudents(groupRequest.getStudents().stream()
                .map(studentDto -> {
                    Student entity;
                    if (studentDto != null && studentDto.getStudentId() != null) {
                        entity = studentRepository.findById(studentDto.getStudentId())
                                .orElseThrow(() ->new NotFoundException("Not found student with id "
                                        + studentDto.getStudentId()));

                    } else {
                        entity = studentMapper.toEntity(studentDto);
                    }
                    entity.setGroup(group);
                    return entity;
                })
                .toList());
        Group save = repository.save(group);
        return groupMapper.toDto(save);
    }

    @Override
    public void deleteGroup(Long id) {
        repository.deleteById(id);
    }

    public Group findGroupById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Group not found with id " + id));
    }

    @Override
    public Group updateGroup(Group group) {
        Group groupById = findGroupById(group.getGroupId());
        if (groupById != null) {
            groupById.setGroupName(group.getGroupName());
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
    public Group findByGroupName(String groupName) {
         return repository.findByGroupName(groupName);
    }

    @Override
    public void deleteGroupByName(String groupName) {
        Group byGroupName = findByGroupName(groupName);
        if (byGroupName != null) {
            repository.deleteById(byGroupName.getGroupId());
            return;
        } throw new NotFoundException("Group not found with name " + groupName);
    }

    @Override
    public void deleteAllGroups() {
        repository.deleteAll();
    }
}
