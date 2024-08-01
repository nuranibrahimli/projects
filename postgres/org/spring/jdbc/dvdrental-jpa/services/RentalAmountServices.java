package services;

import entities.RentalAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.RentalAmountRepository;

import java.util.List;

@Service
public class RentalAmountServices {
    @Autowired
    RentalAmountRepository repository;

    public void selectRentalAmount(){
        List<RentalAmount> rentalAmounts = repository.selectRentalAmounts();
        for(RentalAmount amount: rentalAmounts){
            System.out.println(amount.toString());
        }
    }
}
