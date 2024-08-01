package com.example.quiz_2.Controller;

import com.example.quiz_2.Api.ApiResponse;
import com.example.quiz_2.Model.Student;
import com.example.quiz_2.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    final StudentService studentService = new StudentService();


    @GetMapping("/get")
    public ResponseEntity getStudents(){
        ArrayList<Student> students = studentService.getStudents();
        return ResponseEntity.status(200).body(students);
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid @RequestBody Student student , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("student added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id , @RequestBody Student student , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (studentService.updateStudent(id,student)){
            return ResponseEntity.status(200).body(new ApiResponse("student updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id){
        if (studentService.deleteStudent(id)){
            return ResponseEntity.status(200).body(new ApiResponse("student deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }

    @GetMapping("/name/{name}")
    public ResponseEntity getByName(@PathVariable String name){
        if (studentService.get(name) != null){
            return ResponseEntity.status(200).body(studentService.get(name));
        }
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }

    @GetMapping("/major/major")
    public ResponseEntity getByMajor(@PathVariable String major){
        return ResponseEntity.status(200).body(studentService.getMajor(major));
    }

}
