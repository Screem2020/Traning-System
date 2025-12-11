package com.example.traningsystem.dto.student;

import com.example.traningsystem.model.Student;

public class StudentMapper {

    public static StudentDto toDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFirstName(student.getFirstName());
        studentDto.setLastName(student.getLastName());
        if (student.getGroup() != null) {
            studentDto.setGroupId(student.getGroup().getGroupId());
            studentDto.setGroupName(student.getGroup().getGroupName());
        }
        return studentDto;
    }
}
