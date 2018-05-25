package com.abhamish.dao;

import com.abhamish.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("dummyData")
public class DummyStudentRepository implements StudentDao {
    private static Map<Integer,Student> students;

    static {
        students = new HashMap<Integer, Student>(){
            {
                put(1, new Student(1, "Student1","C1"));
                put(2, new Student(2, "Student2","C2"));
                put(3, new Student(3, "Student3","C3"));
            }
        };
    }

    @Override
    public Collection<Student> getAllStudents(){
        return students.values();
    }

    @Override
    public Student getStudentById(int id){
        return students.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        students.remove(id);
    }

    @Override
    public void updateStudent(Student student){
        Student _student = students.get(student.getId());
        _student.setCourse(student.getCourse());
        _student.setName(student.getName());
    }

    @Override
    public void insertStudent(Student student) {
        students.put(student.getId(), student);
    }
}
