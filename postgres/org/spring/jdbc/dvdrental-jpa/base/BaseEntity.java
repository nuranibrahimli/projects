package base;

import java.time.LocalDateTime;

public class BaseEntity {
    private final LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = this.createdAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }
}
