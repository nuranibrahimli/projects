package services;

import entities.StaffReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StaffRepository;

import java.util.List;

@Service
public class StaffServices {
    @Autowired
    StaffRepository repository;

    public void selectStaffAmount(){
        List<StaffReport> staffReports = repository.selectStaffAmountSum();
        for(StaffReport staff: staffReports){
            System.out.println(staff.toString());
        }
    }
}
