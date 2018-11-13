package com.abhamish.controller;

import com.abhamish.entity.Student;
import com.abhamish.service.RedisStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/redisstudents")
public class RedisStudentController {

    @Autowired
    private RedisStudentService studentService;

    @RequestMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public @ResponseBody
    List<Student> userList() {
        return studentService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Student show(@PathVariable("id") String id) {
        return studentService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Student update(@RequestBody Student student) {
        return studentService.save(student);
    }

}