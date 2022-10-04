package dao.custom;

import dao.SuperDAO;
import dto.StudentDTO;
import entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO extends SuperDAO {
    public boolean add(Student student) throws SQLException, ClassNotFoundException;
    public String getLastStudentID() throws Exception;
    public List<Student> getAll() throws Exception;
    public Student searchStudent(String nic) throws Exception;

}
