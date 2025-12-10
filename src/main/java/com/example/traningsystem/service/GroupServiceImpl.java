package com.example.traningsystem.service;

import com.example.traningsystem.dao.GroupRepository;
import com.example.traningsystem.model.Groups;
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
    public void addGroup(Groups group) {
        repository.save(group);
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
