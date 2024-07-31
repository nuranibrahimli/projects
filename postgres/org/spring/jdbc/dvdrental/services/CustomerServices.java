package services;

import entities.CustomerPaymentReport;
import entities.CustomerReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerServices {
    @Autowired
    CustomerRepository repository;

    public void selectCustomerRentalCount(){
        List<CustomerReport> customerReports = repository.selectCustomerRentalCount();
        for(CustomerReport customer: customerReports){
            System.out.println(customer.toString());
        }
    }

    public void selectCustomerSumPayment(){
        List<CustomerReport> reports = repository.selectCustomerWithPayment();
        for(CustomerReport customer: reports){
            System.out.println(customer.toString());
        }
    }

    public void selectCustomerSumPayment(int limit){
        List<CustomerReport> reports = repository.selectCustomerWithPayment(limit);
        for(CustomerReport customer: reports){
            System.out.println(customer.toString());
        }
    }

    public void selectCustomerNonPaying(){
        List<CustomerPaymentReport> reports = repository.selectNonPayingCustomers();
        for(CustomerPaymentReport customer: reports){
            System.out.println(customer.toString());
        }
    }

    public void selectCustomerAvgPayment(int limit){
        List<CustomerReport> reports = repository.selectAvgPaymentCustomers();
        for(CustomerReport customer: reports){
            System.out.println(customer.toString());
        }
    }
}

