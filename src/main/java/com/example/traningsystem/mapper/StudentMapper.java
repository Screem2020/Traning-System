package com.example.traningsystem.mapper;

import com.example.traningsystem.dto.student.StudentDto;
import com.example.traningsystem.model.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toDto(StudentDto studentDto);
    StudentDto toEntity(Student student);
}
