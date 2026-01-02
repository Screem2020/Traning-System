//package com.example.traningsystem.dao.memory;
//
//import com.example.traningsystem.model.TeacherEntity;
//import lombok.AllArgsConstructor;
//import lombok.SneakyThrows;
//import org.springframework.data.crossstore.ChangeSetPersister;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//
//@AllArgsConstructor
//@Repository
//public class TeacherDao {
//    private final List<TeacherEntity> TEACHERS;
//
//    public void save(TeacherEntity teacher) {
//        TEACHERS.add(teacher);
//    }
//
//    public List<TeacherEntity> findAllTeachers() {
//        return TEACHERS;
//    }
//
//    @SneakyThrows
//    public TeacherEntity findTeacherById(Integer id) {
//       return TEACHERS.stream()
//                .filter(element -> element.getTeacherId().equals(id))
//                .findFirst()
//                .orElseThrow(ChangeSetPersister.NotFoundException::new);
//    }
//
//    public void deleteTeacherById(Integer id) {
//        TEACHERS.removeIf(element -> element.getTeacherId().equals(id));
//    }
//
//    public TeacherEntity updateTeacher(TeacherEntity teacher) {
//        TeacherEntity findTeacher = findTeacherById(teacher.getTeacherId());
//        findTeacher.setFirstName(teacher.getFirstName());
//        findTeacher.setLastName(teacher.getLastName());
//        findTeacher.setCourse(teacher.getCourse());
//        return findTeacher;
//    }
//
//}
