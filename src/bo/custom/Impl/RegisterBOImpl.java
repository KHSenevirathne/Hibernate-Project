package bo.custom.Impl;

import bo.custom.RegisterBO;
import dao.DAOFactory;
import dao.custom.CourseDAO;
import dao.custom.RegisterDAO;
import dao.custom.impl.RegisterDAOImpl;
import dto.CourseDTO;
import dto.RegisterDTO;
import entity.Course;
import entity.Registration;

import java.util.ArrayList;
import java.util.List;

public class RegisterBOImpl implements RegisterBO {
    RegisterDAO registerDAO = (RegisterDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.REGISTER);

    @Override
    public boolean registerStudent(RegisterDTO dto) throws Exception {
        return registerDAO.add(new Registration(dto.getRegNo(),dto.getRegDate(),dto.getFee(),dto.getStudent(),dto.getCourses()));
    }

    @Override
    public ArrayList<Object[]> getCourseByStudent(String sID) throws Exception {
        return registerDAO.getCourseByStudent(sID);
    }
}
