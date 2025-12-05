package com.example.traningsystem.service;

import com.example.traningsystem.model.Groups;

import java.util.List;

public interface ServiceGroups {
    void  addGroup(Groups group);
    void deleteGroup(Integer id);
    Groups findGroupById(int id);
    Groups updateGroup(Groups group);
    List<Groups> findAllGroups();
}
