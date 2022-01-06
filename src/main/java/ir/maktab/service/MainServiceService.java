package ir.maktab.service;

import ir.maktab.dao.MainServiceDao;
import ir.maktab.model.MainService;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class MainServiceService {
    private MainServiceDao mainServiceDao;

    public void save(MainService mainService) {
        mainServiceDao.save(mainService);
    }

    public MainService findMainService(String name) {
        Optional<MainService> mainService = mainServiceDao.findByName(name);
        if (mainService.isPresent()) {
            return mainService.get();
        } else {
            throw new RuntimeException("this mainService not exist!");
        }
    }
}
