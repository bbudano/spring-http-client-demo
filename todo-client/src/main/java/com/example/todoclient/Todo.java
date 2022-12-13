package com.example.todoclient;

import java.time.LocalDate;

public record Todo(Integer id, String task, LocalDate deadline, boolean isDone) {
}
