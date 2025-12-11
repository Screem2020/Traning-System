//package com.example.traningsystem.service.Implmemory;
//
//import com.example.traningsystem.dao.memory.GroupDao;
//import com.example.traningsystem.model.Groups;
//import com.example.traningsystem.service.ServiceGroups;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//import java.util.List;
//
//@Service
//@AllArgsConstructor
//public class ImplGroupsInMemory implements ServiceGroups {
//
//    private GroupDao repository;
//
//    @Override
//    public void addGroup(Groups group) {
//        repository.addGroup(group);
//    }
//
//    @Override
//    public void deleteGroup(java.lang.Integer id) {
//        repository.deleteGroup(id);
//    }
//
//    @Override
//    public Groups findGroupById(java.lang.Integer id) {
//        return repository.findGroupById(id);
//    }
//
//    @Override
//    public Groups updateGroup(Groups group) {
//        return repository.updateGroup(group);
//    }
//
//    @Override
//    public List<Groups> findAllGroups() {
//        return repository.findAllGroups();
//    }
//}
