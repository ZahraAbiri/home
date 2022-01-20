package service;

import ir.maktab.config.Config;
import ir.maktab.model.Address;
import ir.maktab.model.Customer;
import ir.maktab.model.Order;
import ir.maktab.model.SubService;
import ir.maktab.model.enums.OrderStatus;
import ir.maktab.service.AddressService;
import ir.maktab.service.CustomerService;
import ir.maktab.service.OrderService;
import ir.maktab.service.SubServiceService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    CustomerService customerService = context.getBean(CustomerService.class);
    SubServiceService subServiceService = context.getBean(SubServiceService.class);
    OrderService orderService = context.getBean(OrderService.class);
    AddressService addressService = context.getBean(AddressService.class);
    Order order;

    @Before
    public void init() {
        Customer customer = customerService.findByEmailAddress("maryam@gmail.com");
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("1400-10-15 12:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SubService subService = subServiceService.findByName("cleaning");
        Address address = addressService.findByZipCode(86165841L);
        order = Order.builder()
                .proposedPrice(1000000L)
                .jobDescription("description")
                .dateOfWorkPerformed(date)
                .address(address)
                .customer(customer)
                .orderStatus(OrderStatus.WATINGFOREXPERTSUGESTION)
                .subService(subService)
                .build();
    }

    @Test
    public void givenOrder_WhenSave_ThenReturnOrder() {
        Order savedOrder = orderService.save(order);
        assertEquals(order, savedOrder);
    }
}
