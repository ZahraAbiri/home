package ir.maktab.data;

import ir.maktab.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CustomerDao extends JpaRepository<Customer,Integer> {
    static void update(Customer customer) {
    }

    Optional<Customer> findByEmailAddress(String email);

}
