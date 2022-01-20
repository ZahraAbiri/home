package ir.maktab.service;

import ir.maktab.data.OrderDao;

import ir.maktab.model.Offer;
import ir.maktab.model.Order;
import ir.maktab.model.enums.OfferStatus;
import ir.maktab.model.enums.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDao orderDao;

    public Order saveOrder(Order order) {
        return orderDao.save(order);
    }

    public Order findById(Integer id) {
        Optional<Order> order = orderDao.findById(id);
        return order.orElseThrow(() -> new RuntimeException("this order not exist!"));
    }

    public Offer findAcceptedOfferOfOrder(Order order) {
        Offer acceptedOffer = null;
        if (order.getOrderStatus().equals(OrderStatus.PAID)) {
            Set<Offer> offers = order.getOffers();
            for (Offer offer : offers) {
                if (offer.getOfferStatus().equals(OfferStatus.ACCEPTED)) {
                    acceptedOffer = offer;
                }
            }
            return acceptedOffer;
        } else {
            throw new RuntimeException("Order not Paid!");
        }
    }


    public Order save(Order order) {
       return orderDao.save(order);
    }
}
