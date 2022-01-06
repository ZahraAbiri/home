package ir.maktab.model.builder;

import ir.maktab.model.entity.services.SubService;
import ir.maktab.model.entity.users.Expert;
import ir.maktab.model.enumeration.UserStatus;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public final class ExpertBuilder {
    private byte[] photo;
    private Double score;
    private Set<SubService> services = new HashSet<>();
    private Integer id;
    private String firstname;
    private String lastname;
    private String emailAddress;
    private String password;
    private UserStatus userStatus;
    private Date registrationDate;
    private Long credit;

    private ExpertBuilder() {
    }

    public static ExpertBuilder anExpert() {
        return new ExpertBuilder();
    }

    public ExpertBuilder withPhoto(byte[] photo) {
        this.photo = photo;
        return this;
    }

    public ExpertBuilder withScore(Double score) {
        this.score = score;
        return this;
    }

    public ExpertBuilder withServices(Set<SubService> services) {
        this.services = services;
        return this;
    }

    public ExpertBuilder withId(Integer id) {
        this.id = id;
        return this;
    }

    public ExpertBuilder withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ExpertBuilder withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ExpertBuilder withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public ExpertBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public ExpertBuilder withUserStatus(UserStatus userStatus) {
        this.userStatus = userStatus;
        return this;
    }

    public ExpertBuilder withRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public ExpertBuilder withCredit(Long credit) {
        this.credit = credit;
        return this;
    }

    public Expert build() {
        Expert expert = new Expert();
        expert.setPhoto(photo);
        expert.setScore(score);
        expert.setServices(services);
        expert.setId(id);
        expert.setFirstname(firstname);
        expert.setLastname(lastname);
        expert.setEmailAddress(emailAddress);
        expert.setPassword(password);
        expert.setUserStatus(userStatus);
        expert.setRegistrationDate(registrationDate);
        expert.setCredit(credit);
        return expert;
    }
}
