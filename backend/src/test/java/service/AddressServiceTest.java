package service;

import ir.maktab.config.Config;
import ir.maktab.model.Address;
import ir.maktab.service.AddressService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class AddressServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    AddressService addressService = context.getBean(AddressService.class);
    Address address;

    @Before
    public void init() {
        address = Address
                .builder()
                .city("tehran")
                .streetAddress("ghazvini.st")
                .houseNumber("12")
                .zipCode(86165841L)
                .build();

    }

    @Test
    public void givenNewAddress_WhenSave_ThenReturnAddress() {
        Address savedAddress = addressService.save(address);
        assertEquals(address, savedAddress);
    }

    @Test
    public void givenExistAddress_WhenSave_ThenReturnAddress() {
        Address savedAddress = addressService.save(address);
        assertEquals(address.getZipCode(), savedAddress.getZipCode());
    }
}
