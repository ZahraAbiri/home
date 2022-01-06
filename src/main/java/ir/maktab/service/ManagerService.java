package ir.maktab.service;

import ir.maktab.dao.ManagerDao;
import ir.maktab.model.Manager;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class ManagerService {
    private ManagerDao managerDao;

    public void save(Manager manager) {
        managerDao.save(manager);
    }

    public Boolean isManagerExist(String username) {
        Boolean exist = false;
        Optional<Manager> manager = managerDao.findByUsername(username);
        if (manager.isPresent()) {
            exist = true;
        } else {
            throw new RuntimeException("username not exist!");
        }
        return exist;
    }

    public Manager findByUsername(String username) {
        Optional<Manager> manager = managerDao.findByUsername(username);
        if (manager.isPresent()) {
            Manager foundedManager = manager.get();
            return foundedManager;
        } else {
            throw new RuntimeException("username not exist!");
        }
    }
}
