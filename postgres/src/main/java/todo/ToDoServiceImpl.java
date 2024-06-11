package todo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ToDoServiceImpl implements ToDoService {
    private Connection connection;

    public ToDoServiceImpl() {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void addTodo(ToDo todo_list) {
        String query = "INSERT INTO todo_list (title, note, duedate) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, todo_list.getTitle());
            pstmt.setString(2, todo_list.getNote());
            pstmt.setTimestamp(3, Timestamp.valueOf(todo_list.getDueDate()));
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            System.out.println("Error adding ToDo: " + e.getMessage());
        }
    }

    @Override
    public void deleteTodoByTitle(String title) {
        String query = "DELETE FROM todo_list WHERE title = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, title);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            System.out.println("Error deleting ToDo: " + e.getMessage());
        }
    }

    @Override
    public void editTodoTitle(String oldTitle, String newTitle) {
        String query = "UPDATE todo_list SET title = ? WHERE title = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, newTitle);
            pstmt.setString(2, oldTitle);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            System.out.println("Error editing ToDo: " + e.getMessage());
        }
    }

    @Override
    public List<ToDo> getAllTodos() {
        List<ToDo> todos = new ArrayList<>();
        String query = "SELECT * FROM todo_list";
        try (PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                ToDo todo_list = new ToDo(
                        rs.getString("title"),
                        rs.getString("note"),
                        rs.getTimestamp("duedate").toLocalDateTime()
                );
                todos.add(todo_list);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving ToDos: " + e.getMessage());
        }
        return todos;
    }

    @Override
    public List<ToDo> getAllTodos(String p_title) {
        List<ToDo> todos = new ArrayList<>();
        String query = "SELECT * FROM todo_list WHERE title ILIKE ?";
        try (PreparedStatement pstmt = connection.prepareStatement(query)) {
            pstmt.setString(1, "%" + p_title + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    ToDo todo = new ToDo(
                            rs.getString("title"),
                            rs.getString("note"),
                            rs.getTimestamp("duedate").toLocalDateTime()
                    );
                    todos.add(todo);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error searching ToDos: " + e.getMessage());
        }
        return todos;
    }

    @Override
    public List<ToDo> getOverdueTodos() {
        List<ToDo> todos = new ArrayList<>();
        String query = "SELECT * FROM todo_list WHERE duedate < NOW()";
        try (PreparedStatement pstmt = connection.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                ToDo todo = new ToDo(
                        rs.getString("title"),
                        rs.getString("note"),
                        rs.getTimestamp("duedate").toLocalDateTime()
                );
                todos.add(todo);
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving overdue ToDos: " + e.getMessage());
        }
        return todos;
    }
}
