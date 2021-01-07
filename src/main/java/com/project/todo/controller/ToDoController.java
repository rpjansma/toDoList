package com.project.todo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ToDoController {
    @RequestMapping("/api/todo")
    public String helloWorld() {
        return "Oi";
    }
}
