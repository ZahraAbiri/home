package ir.maktab.dao;

import ir.maktab.model.Expert;
import ir.maktab.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Optional;

public class ExpertDao {
    private SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

    public void save(Expert expert) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(expert);
        transaction.commit();
        session.close();
    }

    public Optional<Expert> findByEmailAddress(String email) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Expert> query = session.createQuery("FROM Expert expert WHERE expert.emailAddress=:emailValue");
        query.setParameter("emailValue", email);
        Optional<Expert> expert = Optional.ofNullable(query.uniqueResult());
        transaction.commit();
        session.close();
        return expert;
    }
}
