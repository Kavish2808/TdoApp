package com.Kavish.ToDo;


import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class TodoController {

    private final TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @PostMapping("/save")
    public String save(@RequestBody Task task) {
        return service.save(task);
    }

    @GetMapping("/findall")
    public List<Task> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/deletebyid/{id}")
    public String deleteById(@PathVariable int id) {
        return service.deleteById(id);
    }
}
