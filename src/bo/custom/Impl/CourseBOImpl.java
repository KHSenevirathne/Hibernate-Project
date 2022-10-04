package bo.custom.Impl;

import bo.custom.CourseBO;
import dao.DAOFactory;
import dao.custom.CourseDAO;
import dao.custom.impl.CourseDAOImpl;
import dto.CourseDTO;
import entity.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseBOImpl implements CourseBO {
    private CourseDAO courseDAO= (CourseDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.COURSE);

    @Override
    public boolean saveCourse(CourseDTO dto) throws Exception {
        return courseDAO.add(new Course(dto.getPID(),dto.getPName(),dto.getDuration(),dto.getFee()));
    }


    @Override
    public boolean deleteCourse(String id) throws Exception {
        return courseDAO.delete(id);
    }

    /*@Override
    public CourseDTO getCourse(String id) throws Exception {
        Course customer=courseDAO.(id);
        return new CourseDTO(customer.getCustId(),customer.getName(),customer.getAddress());
    }*/

    @Override
    public ArrayList<CourseDTO> getAllCourse() throws Exception {
        List<Course> list = courseDAO.getAll();
        ArrayList<CourseDTO> arrayList = new ArrayList<>();
        for (Course course : list) {
            arrayList.add(new CourseDTO(course.getPID(),course.getPName(),course.getDuration(),course.getFee()));
        }
        return arrayList;
    }
    @Override
    public Course searchCourse(String courseName) throws Exception {
        Course course = courseDAO.searchCourse(courseName);
        System.out.println(course.toString());
        return courseDAO.searchCourse(courseName);
    }

    @Override
    public Course getCourse(String sID) throws Exception {
        return courseDAO.getCourse(sID);
    }
}
