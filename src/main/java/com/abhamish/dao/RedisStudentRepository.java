package com.abhamish.dao;

import com.abhamish.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Repository
public class RedisStudentRepository {
    @Autowired
    private RedisTemplate<String, Student> redisTemplate;

    public void save(Student student){
        redisTemplate.opsForValue().set(String.valueOf(student.getId()), student);
    }

    public Student getById(int key){
            return redisTemplate.opsForValue().get(String.valueOf(key));
    }

    public List<Student> findAll() {
        List<Student> userList = new ArrayList<>();

        Set<String> keys = redisTemplate.keys("*");
        Iterator<String> it = keys.iterator();

        while(it.hasNext()){
            userList.add(getById(Integer.parseInt(it.next())));
        }
        return userList;
    }

    public void delete(Student student) {
        String key = String.valueOf(student.getId());
        redisTemplate.opsForValue().getOperations().delete(key);
    }
}
