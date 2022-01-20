package ir.maktab.service;


import ir.maktab.data.CustomerDao;
import ir.maktab.model.*;
import ir.maktab.model.enums.OfferStatus;
import ir.maktab.model.enums.OrderStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class CustomerService {
    private CustomerDao customerDao;
    private OrderService orderService;
    private OfferService offerService;


    public Customer save(Customer customer) {
        customerDao.save(customer);
        return customer;
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

    public void deleteCustomer(Customer customer) {
        customerDao.delete(customer);
    }

    public void updateCustomer(Customer customer) {
        CustomerDao.update(customer);
    }


    public List<Customer> findAll() {
        return customerDao.findAll();
    }


    public Customer saveCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    public void acceptOfferForOrder(Order order, Expert expert) {
        order.setExpert(expert);
        order.setOrderStatus(OrderStatus.WATINGFORTHEEXPERTTOARRIVE);
        orderService.saveOrder(order);
        Offer acceptedOffer = offerService.findByOrderAndExpert(order, expert);
        Set<Offer> offers = order.getOffers();
        for (Offer offer : offers) {
            if (offer.equals(acceptedOffer)) {
                offer.setOfferStatus(OfferStatus.ACCEPTED);
            } else {
                offer.setOfferStatus(OfferStatus.REJECTED);
            }
            offerService.save(offer);
        }
    }

    public void addnewOrder(Order order) {
        order.setOrderStatus(OrderStatus.WATINGFOREXPERTSUGESTION);
        orderService.save(order);
    }

}
