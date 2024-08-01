package com.example.quiz_2.Model;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class Student {
    @NonNull
    private int id;
    @NotEmpty
    private String name;
    @NonNull
    private int age;
    @NotEmpty
    private String major;
}
