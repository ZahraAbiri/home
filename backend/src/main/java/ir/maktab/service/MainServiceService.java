package ir.maktab.service;


import ir.maktab.data.MainServiceDao;
import ir.maktab.model.MainService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Getter
@Setter
public class MainServiceService {
    @Autowired
    private MainServiceDao mainServiceDao;

   public MainService saveMainService(MainService mainService){
       return mainServiceDao.save(mainService);
   }
    public void deleteMainService(MainService mainservice) {
         mainServiceDao.delete( mainservice);
    }
    public MainService findByName(String name) {
       return mainServiceDao.findByName(name);
    }
    public List<MainService> findAll() {
       return mainServiceDao.findAll();
    }


}
