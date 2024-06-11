package todo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ToDo {
    private String title;
    private String note;
    private LocalDateTime dueDate;

    public ToDo(String title, String note, LocalDateTime dueDate) {
        this.title = title;
        this.note = note;
        this.dueDate = dueDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return "ToDo{" +
                "title='" + title + '\'' +
                ", note='" + note + '\'' +
                ", dueDate=" + dueDate.format(formatter) +
                '}';
    }
}
