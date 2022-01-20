package ir.maktab.data;

import ir.maktab.model.Expert;
import ir.maktab.model.Offer;
import ir.maktab.model.Order;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfferDao extends JpaRepository<Offer,Integer> {
    List<Offer> findByOrder(Order order, Sort proposedPrice);

    Optional<Offer> findByOrderAndExpert(Order order, Expert expert);
}
