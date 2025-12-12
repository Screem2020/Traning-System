//package com.example.traningsystem.service.Implmemory;
//
//import com.example.traningsystem.dao.memory.TeacherDao;
//import com.example.traningsystem.model.Teacher;
//import com.example.traningsystem.service.ServiceTeacher;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@AllArgsConstructor
//public class ImplTeacherInMemory implements ServiceTeacher {
//
//    private TeacherDao repository;
//
//
//    @Override
//    public void save(Teacher teacher) {
//        repository.save(teacher);
//    }
//
//    @Override
//    public List<Teacher> findAllTeachers() {
//        return repository.findAllTeachers();
//    }
//
//    @Override
//    public Teacher findTeacherById(Integer id) {
//        return repository.findTeacherById(id);
//    }
//
//    @Override
//    public void deleteTeacherById(Integer id) {
//        repository.deleteTeacherById(id);
//    }
//
//    @Override
//    public Teacher updateTeacher(Teacher teacher) {
//        return repository.updateTeacher(teacher);
//    }
//}
