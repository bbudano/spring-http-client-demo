package com.example.todoservice;

import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public record Todo(@Id Integer id, String task, LocalDate deadline, boolean isDone) {
}
