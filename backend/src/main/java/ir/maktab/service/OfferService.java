package ir.maktab.service;

import ir.maktab.data.OfferDao;
import ir.maktab.data.OrderDao;
import ir.maktab.model.Expert;
import ir.maktab.model.Offer;
import ir.maktab.model.Order;
import ir.maktab.model.SubService;
import ir.maktab.model.enums.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OfferService {
    private final OfferDao offerDao;
    private final OrderDao orderDao;

    public Offer save(Offer offer) {
        return offerDao.save(offer);
    }

    public Order addOfferToOrder(Offer offer) {
        Set<SubService> expertServices = offer.getExpert().getServices();
        SubService subService = offer.getOrder().getSubService();
        if (expertServices.contains(subService) && subService.getBasePrice() <= offer.getProposedPrice()) {
            Offer savedOffer = save(offer);
            Order order = savedOffer.getOrder();
            order.setOrderStatus(OrderStatus.WATINGFOREXPORTSELECTION);
            order.getOffers().add(offer);
            orderDao.save(order);
            return order;
        } else {
            throw new RuntimeException("your offer is not match for this Order!");
        }
    }

    public List<Offer> findByOrder(Order order) {
        return offerDao.findByOrder(order, Sort.by("expert.score", "proposedPrice").descending());
    }

    public Offer findByOrderAndExpert(Order order, Expert expert) {
        Optional<Offer> offer = offerDao.findByOrderAndExpert(order, expert);
        return offer.orElseThrow(() -> new RuntimeException("offer not found!"));
    }
}
