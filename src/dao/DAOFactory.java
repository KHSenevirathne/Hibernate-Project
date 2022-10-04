package dao;

import dao.custom.impl.CourseDAOImpl;
import dao.custom.impl.RegisterDAOImpl;
import dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDAOFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    //factory method
    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case COURSE:
                return new CourseDAOImpl();
            case REGISTER:
                return new RegisterDAOImpl();
            case STUDENT:
                return new StudentDAOImpl();
            default:
                return null;
        }
    }

    public enum DAOTypes {
        COURSE,REGISTER,STUDENT
    }
}
