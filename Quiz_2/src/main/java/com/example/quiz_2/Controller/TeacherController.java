package com.example.quiz_2.Controller;


import com.example.quiz_2.Api.ApiResponse;
import com.example.quiz_2.Model.Teacher;
import com.example.quiz_2.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    final TeacherService teacherService = new TeacherService();

    @GetMapping("/get")
    public ResponseEntity getTeachers(){
        return ResponseEntity.status(200).body(teacherService.getTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid @RequestBody Teacher teacher , Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable int id ,@RequestBody Teacher teacher , Errors errors ){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (teacherService.updateTeacher(id,teacher)){
            return ResponseEntity.status(200).body(new ApiResponse("teacher updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id){
        if (teacherService.deleteTeachers(id)){
            return ResponseEntity.status(200).body(new ApiResponse("teacher deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }

    @GetMapping("/search/{id}")
    public ResponseEntity getById(@PathVariable int id){
        if (teacherService.getId(id) != null){
            return ResponseEntity.status(200).body(teacherService.getId(id));
        }
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }

    @GetMapping("/salary/{salary}")
    public ResponseEntity aboveSalary(@PathVariable int salary){
        return ResponseEntity.status(200).body(teacherService.getSalary(salary));
    }




















}
