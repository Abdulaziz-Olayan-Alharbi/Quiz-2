package com.example.quiz_2.Service;

import com.example.quiz_2.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {

    ArrayList<Teacher> teachers = new ArrayList<Teacher>();

    public ArrayList<Teacher> getTeachers (){
        return teachers;
    }

    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    public boolean updateTeacher(int id , Teacher teacher){
        for (int i = 0; i < teachers.size(); i++){
            if (teachers.get(i).getId() == id){
                teachers.set(i, teacher);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTeachers (int id){
        for (int i = 0; i < teachers.size(); i++){
            if (teachers.get(i).getId() == id){
                teachers.remove(i);
                return true;
            }
        }
        return false;
    }

    public Teacher getId (int id){
        for (Teacher teacher : teachers){
            if (teacher.getId() == id){
                return teacher;
            }
        }
        return null;
    }

    public ArrayList<Teacher> getSalary(int salary){
        ArrayList<Teacher> aboveSalary = new ArrayList<Teacher>();
        for (Teacher teacher :teachers){
            if (teacher.getSalary() >= salary){
                aboveSalary.add(teacher);
            }
        }
        return aboveSalary;
    }

}
