package com.example.traningsystem.dao;

import com.example.traningsystem.model.Groups;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Repository
public class GroupDao {
    private List<Groups> groups;

    public void  addGroup(Groups group) {
        groups.add(group);
    }

    public void deleteGroup(java.lang.Integer id) {
        Groups groupById = findGroupById(id);
        groups.remove(groupById);
    }

    public Groups findGroupById(Integer id) {
        return groups.stream().filter(g -> Objects.equals(g.getGroupId(), id))
                .findFirst()
                .orElse(null);
    }

    public Groups updateGroup(Integer id) {
        Groups groupById = findGroupById(id);
        groupById.setGroupName(groupById.getGroupName());
        return groupById;
    }

    public List<Groups> findAllGroups() {
        return groups;
    }
}
