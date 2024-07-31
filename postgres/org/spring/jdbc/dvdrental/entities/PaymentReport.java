package entities;

import base.BaseEntity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("entities")
public class PaymentReport extends BaseEntity {
    private String rentalMonth;
    private int rentalCount;

    // getter methods
    public String getRentalMonth() {
        return rentalMonth;
    }

    public int getRentalCount() {
        return rentalCount;
    }

    // setter methods
    public void setRentalMonth(String rentalMonth) {
        this.rentalMonth = rentalMonth;
    }

    public void setRentalCount(int rentalCount) {
        this.rentalCount = rentalCount;
    }

    @Override
    public String toString() {
        return "PaymentReport{" +
                "rental month='" + rentalMonth + '\'' +
                ", rental count=" + rentalCount +
                '}';
    }
}
