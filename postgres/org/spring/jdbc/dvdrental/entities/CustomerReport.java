package entities;

import base.BaseEntity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("entities")
public class CustomerReport extends BaseEntity {
    private int customerID;
    private String fullName;
    private int rentalCount;
    private double amounts;

    // getter methods
    public int getCustomerID() {
        return customerID;
    }

    public String getFullName() {
        return fullName;
    }

    public int getRentalCount() {
        return rentalCount;
    }

    public double getAmounts(){
        return amounts;
    }

    // setter methods
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setRentalCount(int rentalCount) {
        this.rentalCount = rentalCount;
    }

    public void setAmounts(double amounts){
        this.amounts = amounts;
    }

    @Override
    public String toString() {
        return "CustomerReport{" +
                "customer id=" + customerID +
                ", full name='" + fullName + '\'' +
                ", rental count=" + rentalCount +
                ", amount sum="+ amounts +
                '}';
    }
}
