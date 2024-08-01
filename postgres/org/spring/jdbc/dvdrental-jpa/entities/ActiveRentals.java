package entities;

import base.BaseEntity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("entities")
public class ActiveRentals extends BaseEntity {
    private int activeRentalCount;

    public int getActiveRentalCount() {
        return activeRentalCount;
    }

    public void setActiveRentalCount(int activeRentalCount) {
        this.activeRentalCount = activeRentalCount;
    }

    @Override
    public String toString() {
        return "ActiveRentals{" +
                "Active rentals count=" + activeRentalCount +
                '}';
    }
}
