package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

import java.util.List;

public class GenericDAO<T> {

    private final Class<T> type;

    public GenericDAO(Class<T> type) {
        this.type = type;
    }

    // CREATE
    public void create(T entity) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSession()) {
            tx = session.beginTransaction();

            session.persist(entity);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();

            e.printStackTrace();
        }
    }

    // READ
    public T read(Object id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.find(type, id);
        }
    }

    // READ ALL
    public List<T> readAll() {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("from " + type.getSimpleName(), type).list();
        }
    }

    // UPDATE
    public void update(T entity) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSession()) {
            tx = session.beginTransaction();

            session.merge(entity);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();

            e.printStackTrace();
        }
    }

    // DELETE
    public void delete(Object id) {
        Transaction tx = null;

        try (Session session = HibernateUtil.getSession()) {
            tx = session.beginTransaction();

            T entity = session.find(type, id);

            if (entity != null) session.remove(entity);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();

            e.printStackTrace();
        }
    }
}
