package com.example.traningsystem.mapper;

import com.example.traningsystem.dto.student.CreateStudentRequest;
import com.example.traningsystem.dto.student.StudentDto;
import com.example.traningsystem.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toEntity(StudentDto studentDto);
    StudentDto toDto(Student student);
    @Mapping(target = "studentId", ignore = true)
    Student toEntity(CreateStudentRequest student);
}
