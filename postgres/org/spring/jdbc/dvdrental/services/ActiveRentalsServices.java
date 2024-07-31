package services;

import entities.ActiveRentals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ActiveRentalsRepository;

@Service
public class ActiveRentalsServices {
    @Autowired
    ActiveRentalsRepository repository;

    public void selectActiveRentalsCount(){
        ActiveRentals activeRentals = repository.activeRentals();
        System.out.println(activeRentals.toString());
    }
}
