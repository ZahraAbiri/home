package ir.maktab.dao;


import ir.maktab.model.Person;
import ir.maktab.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Optional;

public class PersonDao {
    private SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

    public void save(Person person) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
        session.close();
    }

    public void update(Person person) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(person);
        transaction.commit();
        session.close();
    }

    public Optional<Person> findByEmailAddress(String email) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Person> query = session.createQuery("FROM Person user WHERE user.emailAddress=:emailValue");
        query.setParameter("emailValue", email);
        Optional<Person> person = Optional.ofNullable(query.uniqueResult());
        transaction.commit();
        session.close();
        return person;
    }
}
