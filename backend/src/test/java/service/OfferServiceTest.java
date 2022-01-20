package service;

import ir.maktab.Exception.NotMatchException;
import ir.maktab.config.Config;
import ir.maktab.model.Expert;
import ir.maktab.model.Offer;
import ir.maktab.model.Order;
import ir.maktab.model.enums.OfferStatus;
import ir.maktab.service.ExpertService;
import ir.maktab.service.OfferService;
import ir.maktab.service.OrderService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OfferServiceTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    OfferService offerService = context.getBean(OfferService.class);
    ExpertService expertService = context.getBean(ExpertService.class);
    OrderService orderService = context.getBean(OrderService.class);
    Offer offer;

    @Test
    public void givenOffer_WhenAddOfferToOrder_ThenReturnOrder() {
        Order foundedOrder = orderService.findById(5);
        Expert expert = expertService.findByEmailAddress("alijafari@gmail.com");
        Date startDate = null;
        try {
            startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("1400-10-15 13:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        offer = Offer.builder()
                .expert(expert)
                .order(foundedOrder)
                .proposedPrice(500000L)
                .durationOfWork(5.3)
                .startTime(startDate)
                .offerStatus(OfferStatus.UNCHECKED)
                .build();
        Order order = offerService.addOfferToOrder(offer);
        assertTrue(order.getOffers().contains(offer));
    }

    @Test
    public void givenOfferThatExpertNotHaveThatSubService_WhenAddOfferToOrder_ThenThrowException() {
        Order order = orderService.findById(5);
        Expert expert = expertService.findByEmailAddress("zamaninasim213@gmail.com");
        Date startDate = null;
        try {
            startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("1400-10-15 13:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        offer = Offer.builder()
                .expert(expert)
                .order(order)
                .proposedPrice(500000L)
                .durationOfWork(5.25)
                .startTime(startDate)
                .offerStatus(OfferStatus.UNCHECKED)
                .build();
        NotMatchException thrown = assertThrows(NotMatchException.class, () -> offerService.addOfferToOrder(offer));
        assertTrue(thrown.getMessage().contains("your offer is not match for this Order!"));
    }

    @Test
    public void givenOfferWhitProposedPriceLessThanBasePrice_WhenAddOfferToOrder_ThenThrowException() {
        Order order = orderService.findById(5);
        Expert expert = expertService.findByEmailAddress("alijafari@gmail.com");
        Date startDate = null;
        try {
            startDate = new SimpleDateFormat("yyyy-MM-dd hh:mm").parse("1400-10-15 13:30");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        offer = Offer.builder()
                .expert(expert)
                .order(order)
                .proposedPrice(1000L)
                .durationOfWork(5.35)
                .startTime(startDate)
                .offerStatus(OfferStatus.UNCHECKED)
                .build();
        NotMatchException thrown = assertThrows(NotMatchException.class, () -> offerService.addOfferToOrder(offer));
        assertTrue(thrown.getMessage().contains("your offer is not match for this Order!"));
    }
}
