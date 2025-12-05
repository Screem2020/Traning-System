package com.example.traningsystem.dao;

import com.example.traningsystem.model.Groups;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class GroupDao {
    private List<Groups> groups = new ArrayList<>();

    public void  addGroup(Groups group) {
        groups.add(group);
    }

    public void deleteGroup(Integer id) {
        Groups groupById = findGroupById(id);
        groups.remove(groupById);
    }

    public Groups findGroupById(int id) {
        return groups.stream().filter(g -> g.getGroupId() == id)
                .findFirst()
                .orElse(null);
    }

    public Groups updateGroup(Groups group) {
        Groups groupById = findGroupById(group.getGroupId());
        groupById.setGroupName(group.getGroupName());
        return groupById;
    }

    public List<Groups> findAllGroups() {
        return groups;
    }
}
