package com.example.addStudent.Student.controller;

import com.example.addStudent.Student.model.StudentModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    List<StudentModel> listStudent = new ArrayList<StudentModel>();

    @PostMapping("/add/byRequestParam")
    public ResponseEntity<?> addStudentByParam(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) int age
    ){

        StudentModel studentModel = new StudentModel();
        studentModel.setName(name);
        studentModel.setAge(age);

        listStudent.add(studentModel);
        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }

    @PostMapping("/add/byPathVariable/{name}/{age}")
    public ResponseEntity<?> addStudentByPathVariable(
            @PathVariable String name,
            @PathVariable int age
    ){

        StudentModel studentModel = new StudentModel();
        studentModel.setName(name);
        studentModel.setAge(age);

        listStudent.add(studentModel);
        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }

    @PostMapping("/add/byRequestBody")
    public ResponseEntity<?> addStudentByRequestBody(
            @RequestBody StudentModel studentModel
    ){

        listStudent.add(studentModel);
        return new ResponseEntity<>(listStudent, HttpStatus.OK);
    }


}
