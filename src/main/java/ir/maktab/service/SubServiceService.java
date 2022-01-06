package ir.maktab.service;

import ir.maktab.dao.SubServiceDao;
import ir.maktab.model.SubService;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class SubServiceService {
    private SubServiceDao subServiceDao;

    public void save(SubService subService) {
        subServiceDao.save(subService);
    }

    public void update(SubService subService) {
        subServiceDao.update(subService);
    }

    public boolean isSubServiceExist(String name) {
        Optional<SubService> subService = subServiceDao.findByName(name);
        if (subService.isPresent()) {
            throw new RuntimeException("this subService exist!");
        }
        return false;
    }

    public SubService findByName(String name) {
        return subServiceDao.findByNameWhitCriteria(name);
    }

    public List<SubService> findAll() {
        return subServiceDao.findAll();
    }
}
