package SpringAndHibernate.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import SpringAndHibernate.Student;

import java.util.List;

/**
 * Created by peakone on 2015/9/17.
 */
public class StudentHbmDao implements StudentDao {
    @Override
    public List<Student> findAll() {
        System.out.println("StudentHbmDao_findAll");
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        List<Student> list = session.createQuery("from Student").list();
        session.close();
        return list;
    }

    @Override
    public void save(Student student) {
        System.out.println("StudentHbmDao_save");
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
    }

    @Override
    public void update(Student student) {
        System.out.println("StudentHbmDao_update");
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
    }

    @Override
    public void delete(Student student) {
        System.out.println("StudentHbmDao_delete");
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(student);
        transaction.commit();
    }
}
