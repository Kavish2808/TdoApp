package com.Kavish.ToDo;


import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class TodoDAO {

    private final JdbcTemplate jt;

    public TodoDAO(JdbcTemplate jt) {
        this.jt = jt;
    }

    public int save(Task task) {
        String sql = "INSERT INTO task(task) VALUES(?)";
        return jt.update(sql, task.getTask());
    }

    public List<Task> findAll() {
        String sql = "SELECT id, task FROM task ORDER BY id DESC";

        return jt.query(
                sql,
                new BeanPropertyRowMapper<>(Task.class)
        );
    }

    public int deleteById(int id) {
        String sql = "DELETE FROM task WHERE id = ?";
        return jt.update(sql, id);
    }
}
