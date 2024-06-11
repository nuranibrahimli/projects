package todo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ToDoApplication {
    public static void main(String[] args) {
        ToDoService toDoService = new ToDoServiceImpl();
        Scanner input = new Scanner(System.in);
        boolean flag = false;

        while (!flag) {
            System.out.println("MENU");
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("3. Edit");
            System.out.println("4. Search");
            System.out.println("5. Show");
            System.out.println("6. Show Overdue");
            System.out.println("q. Quit");
            System.out.println("SELECT OPTION");
            char option = input.nextLine().charAt(0);

            switch (option) {
                case '1':
                    System.out.println("Enter the title: ");
                    String title = input.nextLine();
                    System.out.println("Enter the note");
                    String note = input.nextLine();
                    LocalDateTime due = LocalDateTime.now().plusHours(2);
                    ToDo todo = new ToDo(title, note, due);
                    toDoService.addTodo(todo);
                    break;
                case '2':
                    System.out.println("Enter the title for deleting:");
                    String titleDelete = input.nextLine();
                    toDoService.deleteTodoByTitle(titleDelete);
                    break;
                case '3':
                    System.out.println("Enter the title for editing:");
                    String oldTitle = input.nextLine();
                    System.out.println("Enter the new title:");
                    String newTitle = input.nextLine();
                    toDoService.editTodoTitle(oldTitle, newTitle);
                    break;

                case '4':
                    Scanner scanner = new Scanner(System.in);
                    System.out.println("Search: ");
                    String search = scanner.nextLine();
                    List<ToDo> todos = toDoService.getAllTodos(search);
                    for (ToDo t : todos) {
                        System.out.println(t);
                    }
                    break;
                case '5':
                    List<ToDo> todos1 = toDoService.getAllTodos();
                    for (ToDo t : todos1) {
                        System.out.println(t);
                    }
                    break;

                case '6':
                    List<ToDo> overdueTodos = toDoService.getOverdueTodos();
                    for (ToDo t : overdueTodos) {
                        System.out.println(t);
                    }
                    break;
                case 'q':
                    flag = true;
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }
}