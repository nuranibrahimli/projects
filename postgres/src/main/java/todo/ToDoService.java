package todo;

import java.util.List;

public interface ToDoService {
    void addTodo(ToDo todo_list);
    void deleteTodoByTitle(String title);
    void editTodoTitle(String oldTitle, String newTitle);
    List<ToDo> getAllTodos();

    List<ToDo> getAllTodos(String p_title);

    List<ToDo> getOverdueTodos();
}
