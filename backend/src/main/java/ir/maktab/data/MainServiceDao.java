package ir.maktab.data;

import ir.maktab.model.MainService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainServiceDao extends JpaRepository<MainService,Integer> {
    MainService findByName(String name);

}
