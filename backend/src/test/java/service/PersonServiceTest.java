package service;

import ir.maktab.Exception.EntityIsExistException;
import ir.maktab.Exception.EntityNotExistException;
import ir.maktab.Exception.InCorrectException;
import ir.maktab.config.Config;
import ir.maktab.model.Person;
import ir.maktab.service.PersonService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    PersonService personService = context.getBean(PersonService.class);
    Person person;

//    @Before
//    public void init() {
//        person = Customer.builder()
//                .firstname("sara")
//                .lastname("asadi")
//                .emailAddress("sara@gmail.com")
//                .password("123456")
//                .role(Role.CUSTOMER)
//                .userStatus(PersonStatuse.NEW)
//                .credit(0L)
//                .build();
//    }

    @Test
    public void givenNewUser_WhenSave_ThenReturnUser() {
        Person savedUser = personService.save(person);
        assertEquals(person, savedUser);
    }

    @Test
    public void givenDuplicateUser_WhenSave_ThenThrowException() {
        EntityIsExistException thrown = assertThrows(EntityIsExistException.class, () -> personService.save(person));
        assertTrue(thrown.getMessage().contains("this emailAddress exist!"));
    }

    @Test
    public void givenExistUserEmail_WhenFindByEmailAddress_ThenReturnUser() {
        Person person = personService.findByEmailAddress("nedaakbari213@gmail.com");
        assertNotNull(person);
    }

    @Test
    public void givenNotExistUserEmail_WhenFindByEmailAddress_ThenThrowException() {
        EntityNotExistException thrown =
                assertThrows(EntityNotExistException.class, () -> personService.findByEmailAddress("test@gmail.com"));
        assertTrue(thrown.getMessage().contains("emailAddress not exist!"));
    }

    @Test
    public void givenUserAndCurrentPass_WhenChangePassword_returnUpdatedUser() {
        Person person = personService.findByEmailAddress("asadi@gmail.com");
        Person updatedUser = personService.changePassword(person, "asad1234", "aliA1234");
        assertEquals(updatedUser.getPassword(), "aliA1234");
    }

    @Test
    public void givenUserAndWrongCurrentPass_WhenChangePassword_ThenThrowException() {
        Person person = PersonService.findByEmailAddress("asadi@gmail.com");
        InCorrectException thrown =
                assertThrows(InCorrectException.class, () -> personService.changePassword(person, "aliA1234", "akBar1234"));
        assertTrue(thrown.getMessage().contains("password is wrong!"));
    }




}
