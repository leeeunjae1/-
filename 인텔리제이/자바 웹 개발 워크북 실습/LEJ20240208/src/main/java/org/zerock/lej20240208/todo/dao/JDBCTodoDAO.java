package org.zerock.lej20240208.todo.dao;

import org.zerock.lej20240208.todo.dto.TodoDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JDBCTodoDAO implements TodoDAO {

    @Override
    public void insert(TodoDTO todoDTO) {
        String sql = "INSERT INTO todo (name, id, password, age, gender, hobbies, travel, content) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = org.zerock.lej20240208.todo.dao.ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, todoDTO.getName());
            ps.setString(2, todoDTO.getId());
            ps.setString(3, todoDTO.getPassword());
            ps.setInt(4, todoDTO.getAge());
            ps.setBoolean(5, todoDTO.isGender());
            ps.setString(6, todoDTO.getHobbies());
            ps.setString(7, todoDTO.getTravel());
            ps.setString(8, todoDTO.getContent());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TodoDTO> selectAll() {
        List<TodoDTO> todoList = new ArrayList<>();

        try (Connection connection = org.zerock.lej20240208.todo.dao.ConnectionUtil.INSTANCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM todo");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                TodoDTO todoDTO = new TodoDTO();
                todoDTO.setTno(rs.getLong("tno"));
                todoDTO.setName(rs.getString("name"));
                todoDTO.setId(rs.getString("id"));
                todoDTO.setPassword(rs.getString("password"));
                todoDTO.setAge(rs.getInt("age"));
                todoDTO.setGender(rs.getBoolean("gender"));
                todoDTO.setHobbies(rs.getString("hobbies"));
                todoDTO.setTravel(rs.getString("travel"));
                todoDTO.setContent(rs.getString("content"));

                todoList.add(todoDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return todoList;
    }

}
