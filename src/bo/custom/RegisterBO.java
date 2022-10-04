package bo.custom;

import bo.SuperBO;
import dto.RegisterDTO;
import entity.Course;

import java.util.ArrayList;
import java.util.List;

public interface RegisterBO extends SuperBO {
    public boolean registerStudent(RegisterDTO dto) throws Exception;
    public ArrayList<Object[]> getCourseByStudent(String sID) throws Exception;;
}
