package service;

import ir.maktab.Exception.EntityIsExistException;
import ir.maktab.Exception.EntityNotExistException;
import ir.maktab.config.Config;
import ir.maktab.model.Expert;
import ir.maktab.service.ExpertService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExpertServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    ExpertService expertService = context.getBean(ExpertService.class);
    Expert expert;



    @Test
    public void givenNewExpert_WhenSave_ThenReturnExpert() throws IOException {
        Expert savedExpert = expertService.save(expert);
        assertEquals(expert, savedExpert);
    }

    @Test
    public void givenDuplicateExpert_WhenSave_ThenThrowException() {
        EntityIsExistException thrown = assertThrows(EntityIsExistException.class, () -> expertService.save(expert));
        assertTrue(thrown.getMessage().contains("this emailAddress exist!"));
    }

    @Test
    public void givenExistCustomerEmail_WhenFindByEmailAddress_ThenReturnCustomer() {
        Expert expert = expertService.findByEmailAddress("aliakbargodarzi@gmail.com");
        assertNotNull(expert);
    }

    @Test
    public void givenNotExistCustomerEmail_WhenFindByEmailAddress_ThenThrowException() {
        EntityNotExistException thrown =
                assertThrows(EntityNotExistException.class, () -> expertService.findByEmailAddress("test@gmail.com"));
        assertTrue(thrown.getMessage().contains("emailAddress not exist!"));
    }
}
