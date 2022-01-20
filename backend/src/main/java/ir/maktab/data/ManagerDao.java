package ir.maktab.data;

import ir.maktab.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManagerDao extends JpaRepository<Manager,Integer> {
    Optional<Manager> findByUsername(String username);

}
