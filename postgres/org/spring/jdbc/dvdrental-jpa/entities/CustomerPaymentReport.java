package entities;

import base.BaseEntity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("entities")
public class CustomerPaymentReport extends BaseEntity {
    private int customerID;
    private String firstName;

    // getter methods
    public int getCustomerID() {
        return customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    // setter methods
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "CustomerPaymentReport{" +
                "customer id=" + customerID +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
