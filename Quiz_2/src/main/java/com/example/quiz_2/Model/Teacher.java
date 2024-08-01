package com.example.quiz_2.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Teacher {
    @NotNull
    private int id;
    @NotEmpty
    private String name;
    @NotNull
    private int salary;
}
