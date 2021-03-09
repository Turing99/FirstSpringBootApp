package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //This annotations makes class to serve Rest endpoints
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

@Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {

        return studentService.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) //we take the request body and then we map it into a student
    {
    studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){

     studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ){
        studentService.updateStudent(studentId,name,email);
    }
}