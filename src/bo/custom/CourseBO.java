package bo.custom;

import bo.SuperBO;
import dto.CourseDTO;
import entity.Course;

import java.util.ArrayList;

public interface CourseBO extends SuperBO {
    public boolean saveCourse(CourseDTO dto) throws Exception;
    public boolean deleteCourse(String id) throws Exception;
    public ArrayList<CourseDTO> getAllCourse() throws Exception;
    public Course searchCourse(String courseName)throws Exception;
    public Course getCourse(String sID) throws Exception;
}
