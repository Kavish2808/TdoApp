package com.Kavish.ToDo;


import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodoDAO dao;

    public TodoService(TodoDAO dao) {
        this.dao = dao;
    }

    public String save(Task task) {
        if (task.getTask() == null || task.getTask().trim().isEmpty()) {
            return "task cannot be empty";
        }

        int n = dao.save(task);

        return n > 0 ? "task created" : "task creation failed";
    }

    public List<Task> findAll() {
        return dao.findAll();
    }

    public String deleteById(int id) {
        int n = dao.deleteById(id);

        return n > 0 ? "task deleted" : "task not found";
    }
}
