package com.example.traningsystem.service;

import com.example.traningsystem.dao.GroupRepository;
import com.example.traningsystem.dto.group.CreateGroupRequest;
import com.example.traningsystem.dto.student.StudentDto;
import com.example.traningsystem.dto.student.StudentMapperToDto;
import com.example.traningsystem.dto.student.StudentMapperToEntity;
import com.example.traningsystem.model.Groups;
import com.example.traningsystem.model.Student;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Primary;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import java.util.List;

@Primary
@AllArgsConstructor
@Service
public class GroupServiceImpl implements ServiceGroups {

    private final GroupRepository repository;

    @Override
    public void addGroup(CreateGroupRequest groupRequest) {
        Groups group = new Groups();
        group.setGroupName(groupRequest.getGroupName());
        group.setStudents(groupRequest.getStudents().stream()
                .map(StudentMapperToDto::toEntity)
                .toList());
    }

    @Override
    public void deleteGroup(Integer id) {
        repository.deleteById(id);
    }

    @SneakyThrows
    @Override
    public Groups findGroupById(Integer id) {
        return repository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);
    }

    @Override
    public Groups updateGroup(Groups group) {
        Groups groupById = findGroupById(group.getGroupId());
        if (groupById != null) {
            groupById.setGroupName(groupById.getGroupName());
            groupById.setStudents(group.getStudents());
            return repository.save(groupById);
        } throw new NullPointerException("Group not found with id " + group.getGroupId());
    }

    @Override
    public List<Groups> findAllGroups() {
        return repository.findAll();
    }
}
