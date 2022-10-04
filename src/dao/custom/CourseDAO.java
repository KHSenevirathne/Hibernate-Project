package dao.custom;

import dao.SuperDAO;
import entity.Course;
import entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface CourseDAO extends SuperDAO {
    public boolean add(Course course) throws SQLException, ClassNotFoundException;
    public List<Course> getAll() throws Exception;
    public boolean delete(String s) throws Exception;
    public Course searchCourse(String course) throws Exception;
    public Course getCourse(String nic) throws Exception;
}
