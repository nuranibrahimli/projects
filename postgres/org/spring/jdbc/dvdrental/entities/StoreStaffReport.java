package entities;

public class StoreStaffReport {
    private int storeId;
    private int staffCount;

    // Getters and setters
    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getStaffCount() {
        return staffCount;
    }

    public void setStaffCount(int staffCount) {
        this.staffCount = staffCount;
    }

    @Override
    public String toString() {
        return "Store ID: " + storeId + ", Staff Count: " + staffCount;
    }
}