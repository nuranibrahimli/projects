package services;

import entities.PaymentReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentServices {
    @Autowired
    PaymentRepository repository;

    public void selectPayments(){
        List<PaymentReport> reports = repository.selectPaymentForMonthCount();
        for(PaymentReport payment: reports){
            System.out.println(payment.toString());
        }
    }
}
