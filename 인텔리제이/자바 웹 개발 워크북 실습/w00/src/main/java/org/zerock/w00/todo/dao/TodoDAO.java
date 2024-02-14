package org.zerock.w00.todo.dao;

import org.zerock.w00.todo.dto.TodoDTO;

import java.util.List;

public interface TodoDAO {
    void insert(TodoDTO todoDTO);
    List<TodoDTO> selectAll();

}
