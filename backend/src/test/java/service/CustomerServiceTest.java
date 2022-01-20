package service;

import ir.maktab.Exception.EntityIsExistException;
import ir.maktab.Exception.EntityNotExistException;
import ir.maktab.config.Config;
import ir.maktab.model.Customer;
import ir.maktab.model.enums.PersonStatuse;
import ir.maktab.model.enums.Role;
import ir.maktab.service.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    CustomerService customerService = context.getBean(CustomerService.class);
    Customer customer;

    @Before
    public void init() {
        customer = Customer.builder()
                .firstname("zahra")
                .lastname("ahmadi")
                .emailAddress("ahmadi@gmail.com")
                .password("ahmadi")
                .role(Role.CUSTOMER)
                .userStatus(PersonStatuse.NEW)
                .credit(0L)
                .build();
    }

    @Test
    public void givenNewCustomer_WhenSave_ThenReturnCustomer() {
        Customer savedCustomer = customerService.save(customer);
        assertEquals(customer, savedCustomer);
    }

    @Test
    public void givenDuplicateCustomer_WhenSave_ThenThrowException() {
        EntityIsExistException thrown = assertThrows(EntityIsExistException.class, () -> customerService.save(customer));
        assertTrue(thrown.getMessage().contains("this emailAddress exist!"));
    }

    @Test
    public void givenExistCustomerEmail_WhenFindByEmailAddress_ThenReturnCustomer() {
        Customer customer = customerService.findByEmailAddress("maryamgoli213@gmail.com");
        assertNotNull(customer);
    }

    @Test
    public void givenNotExistCustomerEmail_WhenFindByEmailAddress_ThenThrowException() {
        EntityNotExistException thrown =
                assertThrows(EntityNotExistException.class, () -> customerService.findByEmailAddress("test@gmail.com"));
        assertTrue(thrown.getMessage().contains("emailAddress not exist!"));
    }
}
