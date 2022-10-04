package dao.custom;

import dao.SuperDAO;
import entity.Course;
import entity.Registration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface RegisterDAO extends SuperDAO {
    public boolean add(Registration registration) throws SQLException, ClassNotFoundException;
    public ArrayList<Object[]> getCourseByStudent(String nic) throws Exception;
}
