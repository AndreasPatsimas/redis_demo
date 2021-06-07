package org.patsimas.redis_demo.controllers;

import lombok.extern.slf4j.Slf4j;
import org.patsimas.redis_demo.domain.Student;
import org.patsimas.redis_demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/students")
@RestController
@Slf4j
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity createStudent(@RequestBody Student student) {
        log.info("Save student");
        studentRepository.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<Student> findStudents() {
        log.info("Fetch Students");
        return (List<Student>) studentRepository.findAll();
    }
}
