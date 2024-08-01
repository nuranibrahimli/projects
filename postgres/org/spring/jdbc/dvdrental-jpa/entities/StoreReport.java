package entities;

import base.BaseEntity;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@ComponentScan("entities")
public class StoreReport extends BaseEntity {
    private int storeID;
    private double totalRevenue;

    // getter methods
    public int getStoreID() {
        return storeID;
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    // setter methods
    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    public void setTotalRevenue(double totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    @Override
    public String toString() {
        return "StoreReport{" +
                "store id=" + storeID +
                ", total revenue=" + totalRevenue +
                '}';
    }
}
