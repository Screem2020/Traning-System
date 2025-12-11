package com.example.traningsystem.dto.student;

import com.example.traningsystem.model.Groups;
import com.example.traningsystem.model.Student;

public class StudentMapperToDto {

    public static Student toEntity(StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        Groups groups = new Groups();
        groups.setGroupName(studentDto.getGroupName());
        student.setGroup(groups);
        return student;
    }
}
