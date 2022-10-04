package dao.custom.impl;

import dao.custom.CourseDAO;
import entity.Course;
import entity.Student;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.List;

public class CourseDAOImpl implements CourseDAO {

    @Override
    public boolean add(Course course) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(course);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<Course> getAll() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Course");
        List list = query.list();
        transaction.commit();
        session.close();
        return list;
    }

    @Override
    public boolean delete(String s) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Course course = session.get(Course.class, s);
        session.delete(course);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Course searchCourse(String coursename) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("FROM Course WHERE PName = :courseName");
        query.setParameter("courseName", coursename);
        List<Course> list = query.list();
        for (Course course : list) {
            transaction.commit();
            session.close();
            return course;
        }
        transaction.commit();
        session.close();
        return null;
    }

    @Override
    public Course getCourse(String nic) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        final Course course = session.get(Course.class, nic);
        transaction.commit();
        session.close();
        return course;
    }
}