package services;

import entities.StoreReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StoreRepository;

import java.util.List;

@Service
public class StoreServices {
    @Autowired
    StoreRepository repository;

    public void selectStoreRevenue(){
        List<StoreReport> reports = repository.selectStoreWithRevenue();
        for(StoreReport store: reports){
            System.out.println(store.toString());
        }
    }
}
