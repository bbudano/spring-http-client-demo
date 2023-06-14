package com.example.todoclient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.service.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@HttpExchange("/api/v1/todos")
public interface TodoClient {

    @PostExchange
    Mono<Todo> createTodo(@RequestBody Todo todo);

    @GetExchange
    Flux<Todo> getTodos(@RequestHeader Map<String, String> headers);

    @GetExchange("/{id}")
    Mono<Todo> getTodoById(@PathVariable Integer id);

    @PutExchange("/{id}")
    Mono<Todo> updateTodo(@PathVariable Integer id, @RequestBody Todo todo);

    @DeleteExchange("/{id}")
    Mono<Void> deleteTodo(@PathVariable Integer id);

}
