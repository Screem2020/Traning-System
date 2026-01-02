//package com.example.traningsystem.dao.memory;
//
//import com.example.traningsystem.model.Groups;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//import java.util.Objects;
//
//@AllArgsConstructor
//@Repository
//public class GroupDao {
//    private List<Groups> groups;
//
//    public void  addGroup(Groups group) {
//        groups.add(group);
//    }
//
//    public void deleteGroup(Long id) {
//        Groups groupById = findGroupById(id);
//        groups.remove(groupById);
//    }
//
//    public Groups findGroupById(Long id) {
//        return groups.stream().filter(g -> Objects.equals(g.getGroupId(), id))
//                .findFirst()
//                .orElse(null);
//    }
//
//    public Groups updateGroup(Groups group) {
//        Groups groupById = findGroupById(group.getGroupId());
//        if (Objects.nonNull(groupById)) {
//            groupById.setGroupName(group.getGroupName());
//            groupById.setStudents(group.getStudents());
//            return groupById;
//        }
//        throw new NullPointerException("GroupEntity not found with id " + group.getGroupId());
//    }
//
//    public List<Groups> findAllGroups() {
//        return groups;
//    }
//}
