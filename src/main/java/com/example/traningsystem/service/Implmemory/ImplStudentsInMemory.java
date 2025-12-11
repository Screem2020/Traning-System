//package com.example.traningsystem.service.Implmemory;
//
//import com.example.traningsystem.dto.student.CreateStudentRequest;
//import com.example.traningsystem.dto.student.MergeStudentRequest;
//import com.example.traningsystem.dto.student.StudentDto;
//import com.example.traningsystem.model.Student;
//import com.example.traningsystem.dao.memory.StudentsDao;
//import com.example.traningsystem.service.ServiceStudent;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//@AllArgsConstructor
//@Service
//public class ImplStudentsInMemory  {
//
//    private final StudentsDao repository;
//
//    @Override
//    public List<Student> findAllStudents() {
//        return repository.findAllStudents();
//    }
//
//    @Override
//    public void addStudent(CreateStudentRequest student) {
//        repository.addStudent(student);
//
//    }
//
//    @Override
//    public Student updateStudent(CreateStudentRequest student) {
//        return repository.updateStudent(student);
//
//        return null;
//    }
//
//    @Override
//    public void deleteStudent(Integer id) {
//        repository.deleteStudent(id);
//    }
//
//    @Override
//    public void mergeStudent(MergeStudentRequest student) {
////        repository.mergeStudent(student);
//    }
//
//    @Override
//    public Student findStudentById(Integer id) {
//        return repository.findStudentById(id);
//    }
//}
