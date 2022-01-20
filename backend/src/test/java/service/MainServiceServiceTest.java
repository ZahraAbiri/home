package service;

import ir.maktab.Exception.EntityNotExistException;
import ir.maktab.config.Config;
import ir.maktab.model.MainService;
import ir.maktab.service.MainServiceService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainServiceServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    MainServiceService mainServiceService = context.getBean(MainServiceService.class);
    MainService mainService;

//    @Test
//    public void givenNewMainService_WhenSave_ThenReturnMainService() {
//        mainService = MainService.builder().name("Cleaning and hygiene").build();
//        MainService savedMainService = mainServiceService.save(mainService);
//        assertEquals(mainService, savedMainService);
//    }

//    @Test
//    public void givenDuplicateMainService_WhenSave_ThenThrowException() {
//        mainService = MainService.builder().name("Cleaning and hygiene").build();
//        EntityIsExistException thrown = assertThrows(EntityIsExistException.class, () -> mainServiceService.save(mainService));
//        assertTrue(thrown.getMessage().contains("this mainService exist!"));
//    }

    @Test
    public void givenExistMainServiceName_WhenFindByName_ThenReturnMainService() {
        MainService mainService = mainServiceService.findByName("Cleaning and hygiene");
        assertNotNull(mainService);
    }

    @Test
    public void givenNotExistMainServiceName_WhenFindByName_ThenThrowException() {
        EntityNotExistException thrown = assertThrows(EntityNotExistException.class, () -> mainServiceService.findByName("aaa"));
        assertTrue(thrown.getMessage().contains("this mainService not exist!"));
    }
}
