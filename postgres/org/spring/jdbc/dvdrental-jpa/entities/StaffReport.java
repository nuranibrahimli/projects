package entities;

import base.BaseEntity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("entities")
public class StaffReport extends BaseEntity {
    private int staff_id;
    private String full_name;
    private double amount;

    // getter methods
    public int getStaff_id() {
        return staff_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public double getAmount() {
        return amount;
    }

    // setter methods
    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
