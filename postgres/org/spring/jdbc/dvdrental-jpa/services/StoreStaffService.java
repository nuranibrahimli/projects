package services;

import entities.StoreStaffReport;
import org.springframework.stereotype.Service;
import repository.StoreStaffRepository;

import java.util.List;

@Service
public class StoreStaffService {
    private final StoreStaffRepository repository;

    public StoreStaffService(StoreStaffRepository repository) {
        this.repository = repository;
    }

    public void selectStoreWithStaffCount() {
        List<StoreStaffReport> reports = repository.getStaffCountByStore();
        System.out.println("Total number of staff working in each store:");
        for (StoreStaffReport report : reports) {
            System.out.println(report.toString());
        }
    }
}