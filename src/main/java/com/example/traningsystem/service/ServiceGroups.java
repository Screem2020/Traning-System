package com.example.traningsystem.service;

import com.example.traningsystem.model.Groups;
import java.util.List;

public interface ServiceGroups {
    void  addGroup(Groups group);
    void deleteGroup(java.lang.Integer id);
    Groups findGroupById(java.lang.Integer id);
    Groups updateGroup(Integer id);
    List<Groups> findAllGroups();
}
