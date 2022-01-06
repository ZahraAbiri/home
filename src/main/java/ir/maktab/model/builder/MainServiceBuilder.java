package ir.maktab.model.builder;

import ir.maktab.model.SubService;

import java.util.Set;

public final class MainServiceBuilder {
    private Integer id;
    private String name;
    private Set<SubService> subServices;

    private MainServiceBuilder() {
    }

    public static MainServiceBuilder aMainService() {
        return new MainServiceBuilder();
    }

    public MainServiceBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public MainServiceBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public MainServiceBuilder withSubServices(Set<SubService> subServices) {
        this.subServices = subServices;
        return this;
    }

//    public MainService build() {
//        MainService mainService = new MainService();
//        mainService.setId(id);
//        mainService.setName(name);
//        mainService.setSubServices(subServices);
//        return mainService;
//    }
}
