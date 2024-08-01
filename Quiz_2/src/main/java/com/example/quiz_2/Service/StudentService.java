package com.example.quiz_2.Service;

import com.example.quiz_2.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<Student> students = new ArrayList<Student>();

    public ArrayList<Student> getStudents (){
        return students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public boolean updateStudent(int id , Student student){
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getId() == id){
                students.set(i, student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(int id){
        for (int i = 0; i < students.size(); i++){
            if (students.get(i).getId() == id){
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public Student get(String name){
        for (Student student : students){
            if (student.getName().equals(name)){
                return student;
            }
        }
        return null;
    }

    public ArrayList<Student> getMajor(String major){
        ArrayList<Student> majorStudents = new ArrayList<Student>();
        for (Student student : students){
            if (student.getMajor().equals(major)){
                majorStudents.add(student);
            }
        }
        return majorStudents;
    }
}
