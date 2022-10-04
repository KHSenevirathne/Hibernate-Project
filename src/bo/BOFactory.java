package bo;

import bo.custom.Impl.CourseBOImpl;
import bo.custom.Impl.RegisterBOImpl;
import bo.custom.Impl.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBOFactory() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public SuperBO getBO(BoTypes types) {
        switch (types) {
            case COURSE:
                return new CourseBOImpl();
            case STUDENT:
                return new StudentBOImpl();
            case REGISTER:
                return new RegisterBOImpl();
            default:
                return null;
        }
    }

    public enum BoTypes {
        COURSE, STUDENT, REGISTER
    }
}
