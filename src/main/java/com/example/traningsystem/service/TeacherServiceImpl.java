package com.example.traningsystem.service;

import com.example.traningsystem.dao.TeacherRepository;
import com.example.traningsystem.model.Teacher;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Primary;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Primary
@Service
public class TeacherServiceImpl {
    private TeacherRepository repository;

    public void save(Teacher teacher) {
        repository.save(teacher);
    }

    @SneakyThrows
    public Teacher findByIdTeacher(Integer id) {
         return repository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
    }
    @SneakyThrows
    public void deleteTeacher(Integer id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        }
        throw new ChangeSetPersister.NotFoundException();
    }

    @SneakyThrows
    public Teacher updateTeacher(Teacher teacher) {
        Teacher findByTeacher = findByIdTeacher(teacher.getTeacherId());
        if (findByTeacher != null) {
            findByTeacher.setFirstName(teacher.getFirstName());
            findByTeacher.setLastName(teacher.getLastName());
            return repository.save(findByTeacher);
        } throw new ChangeSetPersister.NotFoundException();
}
}
