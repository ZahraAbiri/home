package ir.maktab.data;

import ir.maktab.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {
    Optional<Address> findByZipCode(Long zipCode);
}
