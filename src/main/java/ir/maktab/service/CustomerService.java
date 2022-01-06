package ir.maktab.service;

import ir.maktab.dao.CustomerDao;
import ir.maktab.model.Customer;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class CustomerService {
    private CustomerDao customerDao;
    public void save(Customer customer) {
        customerDao.save(customer);
    }

    public Customer findByEmailAddress(String emailAddress) {
        Optional<Customer> customer = customerDao.findByEmailAddress(emailAddress);
        if (customer.isPresent()) {
            Customer foundedCustomer = customer.get();
            return foundedCustomer;
        } else {
            throw new RuntimeException("emailAddress not exist!");
        }
    }

    public boolean isExist(String emailAddress) {
        Optional<Customer> customer = customerDao.findByEmailAddress(emailAddress);
        if (customer.isPresent()) {
            throw new RuntimeException("this emailAddress exist!");
        } else {
            return false;
        }
    }
}
