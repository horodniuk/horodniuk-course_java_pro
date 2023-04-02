package hometask.hibernate.dao;


import hometask.hibernate.entity.Student;
import hometask.hibernate.util.HibernateSession;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;


public class StudentDao {
    private SessionFactory sessionFactory;

    public StudentDao() {
        sessionFactory = HibernateSession.getSessionFactory();
    }

    public Student save(Student entity) {
        var session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        return entity;
    }

    public void delete(Student entity) {
        var session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        session.delete(entity);
        session.flush();
        transaction.commit();
    }

    public void update(Student entity) {
        var session = sessionFactory.openSession();
        var transaction = session.beginTransaction();
        sessionFactory.openSession().merge(entity);
        transaction.commit();
    }

    public Optional<Student> findById(Long id) {
        var session = sessionFactory.openSession();
        return Optional.ofNullable(session.find(Student.class, id));
    }

    public List<Student> findAll() {
        var session = sessionFactory.openSession();
        var criteria = session.getCriteriaBuilder().createQuery(Student.class);
        criteria.from(Student.class);
        return session.createQuery(criteria).getResultList();
    }
}


