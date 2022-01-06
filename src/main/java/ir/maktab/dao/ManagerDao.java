package ir.maktab.dao;

import ir.maktab.model.Manager;
import ir.maktab.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Optional;

public class ManagerDao {
    private SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

    public void save(Manager manager) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(manager);
        transaction.commit();
        session.close();
    }

    public Optional<Manager> findByUsername(String username) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<Manager> query = session.createQuery("FROM Manager manager WHERE manager.username=:usernameValue");
        query.setParameter("usernameValue", username);
        Optional<Manager> mainService = Optional.ofNullable(query.uniqueResult());
        transaction.commit();
        session.close();
        return mainService;
    }
}
