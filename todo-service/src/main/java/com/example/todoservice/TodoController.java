package com.example.todoservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/api/v1/todos")
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Mono<Todo> createTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @GetMapping
    Flux<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @GetMapping("/{id}")
    Mono<Todo> getTodoById(@PathVariable Integer id){
        return todoRepository.findById(id);
    }

    @PutMapping("/{id}")
    Mono<Todo> updateTodo(@PathVariable Integer id, @RequestBody Todo todo) {
        return todoRepository
                .findById(id)
                .map(t -> new Todo(id, todo.task(), todo.deadline(), todo.isDone()))
                .flatMap(todoRepository::save);
    }

    @DeleteMapping("/{id}")
    Mono<Void> deleteTodo(@PathVariable Integer id) {
        return todoRepository
                .findById(id)
                .flatMap(todoRepository::delete);
    }

}
