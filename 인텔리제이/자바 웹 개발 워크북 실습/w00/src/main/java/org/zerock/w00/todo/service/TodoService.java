package org.zerock.w00.todo.service;

import org.zerock.w00.todo.dao.JDBCTodoDAO;
import org.zerock.w00.todo.dto.TodoDTO;

import java.util.List;

public class TodoService {

    private final JDBCTodoDAO todoDAO;

    public TodoService() {
        this.todoDAO = new JDBCTodoDAO();
    }

    public void register(TodoDTO todoDTO) {
        todoDAO.insert(todoDTO);
    }

    public List<TodoDTO> getList() {
        return todoDAO.selectAll();
    }

}
