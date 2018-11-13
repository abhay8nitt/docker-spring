package com.abhamish.service;

import com.abhamish.dao.StudentDao;
import com.abhamish.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {
    @Autowired
    @Qualifier(value = "dummyData")
    private StudentDao studentDao;


    public Collection<Student> getAllStudents(){
        System.out.println("Got request");
        return studentDao.getAllStudents();
    }

    public Student getStudentById(int id){
        return studentDao.getStudentById(id);
    }

    public void removeStudentById(int id) {
        studentDao.removeStudentById(id);
    }

    public void updateStudent(Student student){
        studentDao.updateStudent(student);
    }

    public void insertStudent(Student student) {
        studentDao.insertStudent(student);
    }
}
