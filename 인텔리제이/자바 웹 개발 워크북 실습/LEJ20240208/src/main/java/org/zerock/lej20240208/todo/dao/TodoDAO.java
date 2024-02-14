package org.zerock.lej20240208.todo.dao;

import org.zerock.lej20240208.todo.dto.TodoDTO;

import java.util.List;

public interface TodoDAO {
    void insert(TodoDTO todoDTO);
    List<TodoDTO> selectAll();

}
