package ir.maktab.service;

import ir.maktab.dao.PersonDao;
import ir.maktab.model.Person;

import lombok.Getter;
import lombok.Setter;

import java.util.Optional;


@Getter
@Setter
public class PersonService {
    private PersonDao personDao;

    public void save(Person person) {
        personDao.save(person);
    }

    public void update(Person person) {
        personDao.update(person);
    }

    public Person findByEmailAddress(String emailAddress) {
        Optional<Person> expert = personDao.findByEmailAddress(emailAddress);
        if (expert.isPresent()) {
            Person foundedUser = expert.get();
            return foundedUser;
        } else {
            throw new RuntimeException("emailAddress not exist!");
        }
    }
}
