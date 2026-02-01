package com.example.traningsystem.mapper;

import com.example.traningsystem.dto.student.CreateStudentRequest;
import com.example.traningsystem.dto.student.StudentDto;
import com.example.traningsystem.model.StudentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto toDto(StudentEntity student);
    @Mapping(target = "id", ignore = true)
    StudentEntity toEntity(CreateStudentRequest student);
}
