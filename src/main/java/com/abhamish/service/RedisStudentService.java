package com.abhamish.service;

import com.abhamish.dao.RedisStudentRepository;
import com.abhamish.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RedisStudentService {

    @Autowired
    private RedisStudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(String id) {
        return studentRepository.getById(Integer.parseInt(id));
    }

    public Student save(Student student) {
        studentRepository.save(student);
        return studentRepository.getById(student.getId());
    }

    public void delete(Student user) {
        studentRepository.delete(user);
    }
}

