package ir.maktab.service;


import ir.maktab.data.SubserviceDao;
import ir.maktab.dto.ExpertDto;
import ir.maktab.model.Expert;
import ir.maktab.model.SubService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class SubServiceService {
    private SubserviceDao subServiceDao;

    private MainServiceService mainServiceService;

    public SubService save(SubService subService) {
        mainServiceService.findByName(subService.getMainService().getName());
        Optional<SubService> foundedSubService = subServiceDao.findByName(subService.getName());
        if (foundedSubService.isPresent()) {
            throw new RuntimeException("this subService exist!");
        } else {
            return subServiceDao.save(subService);
        }
    }

    public SubService update(SubService subService) {
        return subServiceDao.save(subService);
    }

    public SubService findByName(String name) {
        Optional<SubService> subService = subServiceDao.findByName(name);
        return subService.orElseThrow(() -> new RuntimeException("this subService not exist!"));
    }

    public List<SubService> findAll() {
        List<SubService> subServices = new ArrayList<>();
        Iterable<SubService> subServiceIterable = subServiceDao.findAll();
        subServiceIterable.forEach(subServices::add);
        return subServices;
    }

    public SubService addExpertToSubService(Expert expert, SubService subService) {
        subService.getExperts().add(expert);
        return update(subService);
    }

    public SubService removeExpertFromSubService(Expert expert, SubService subService) {
        subService.getExperts().remove(expert);
        return update(subService);
    }



}
