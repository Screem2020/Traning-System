//package com.example.traningsystem.dao.memory;
//
//import com.example.traningsystem.model.Teacher;
//import lombok.AllArgsConstructor;
//import lombok.SneakyThrows;
//import org.springframework.data.crossstore.ChangeSetPersister;
//import org.springframework.stereotype.Repository;
//import java.util.List;
//
//@AllArgsConstructor
//@Repository
//public class TeacherDao {
//    private final List<Teacher> TEACHERS;
//
//    public void save(Teacher teacher) {
//        TEACHERS.add(teacher);
//    }
//
//    public List<Teacher> findAllTeachers() {
//        return TEACHERS;
//    }
//
//    @SneakyThrows
//    public Teacher findTeacherById(Integer id) {
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
//    public Teacher updateTeacher(Teacher teacher) {
//        Teacher findTeacher = findTeacherById(teacher.getTeacherId());
//        findTeacher.setFirstName(teacher.getFirstName());
//        findTeacher.setLastName(teacher.getLastName());
//        findTeacher.setCourse(teacher.getCourse());
//        return findTeacher;
//    }
//
//}
