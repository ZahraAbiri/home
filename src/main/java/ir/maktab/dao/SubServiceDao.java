package ir.maktab.dao;

import ir.maktab.model.SubService;
import ir.maktab.util.HibernateUtil;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class SubServiceDao {
    private SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();

    public void save(SubService subService) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(subService);
        transaction.commit();
        session.close();
    }

    public void update(SubService subService) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(subService);
        transaction.commit();
        session.close();
    }

    public SubService findByNameWhitCriteria(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(SubService.class, "s");
        criteria.setFetchMode("experts", FetchMode.EAGER);
        criteria.add(Restrictions.eq("s.name", name));
        List<SubService> list = criteria.list();
        SubService subService = list.get(0);
        transaction.commit();
        session.close();
        return subService;
    }

    public Optional<SubService> findByName(String name) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<SubService> query = session.createQuery("FROM SubService s WHERE s.name=:nameValue");
        query.setParameter("nameValue", name);
        Optional<SubService> subService = Optional.ofNullable(query.uniqueResult());
        transaction.commit();
        session.close();
        return subService;
    }

    public List<SubService> findAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<SubService> query = session.createQuery("FROM SubService");
        List<SubService> subServices = query.list();
        transaction.commit();
        session.close();
        return subServices;
    }
}
