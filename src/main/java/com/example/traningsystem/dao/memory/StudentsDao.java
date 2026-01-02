//package com.example.traningsystem.dao.memory;
//
//import com.example.traningsystem.model.Groups;
//import com.example.traningsystem.model.StudentEntity;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Repository
//public class StudentsDao {
//    private final List<StudentEntity> STUDENTS = new ArrayList<>();
//
//    public List<StudentEntity> findAllStudents() {
//        return STUDENTS;
//    }
//
//    public void addStudent(StudentEntity student) {
//        STUDENTS.add(student);
//    }
//
//    public StudentEntity findStudentById(int id) {
//        return STUDENTS.stream()
//                .filter(s -> s.getId() == id)
//                .findFirst()
//                .orElse(null);
//    }
//
//
//    public StudentEntity updateStudent(StudentEntity student) {
//        StudentEntity studentById = findStudentById(student.getId());
//        if (studentById != null) {
//            studentById.setFirstName(student.getFirstName());
//            studentById.setLastName(student.getLastName());
//            return student;
//        } throw new NullPointerException("StudentEntity with id " + student.getId() + " not found");
//    }
//
//    public void deleteStudent(java.lang.Integer id) {
//        StudentEntity studentById = findStudentById(id);
//        if (studentById != null) {
//            STUDENTS.remove(studentById);
//        }
//    }
//
//    public void mergeStudent(StudentEntity student) {
//        Groups group = student.getGroup();
//        if (group != null) {
//            List<StudentEntity> students = group.getStudents();
//            students.add(student);
//        }
//    }
//}
