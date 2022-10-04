package util;

//import entity.Course;
//import entity.Registration;
import entity.Course;
import entity.Registration;
import entity.Student;
//import entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private final SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Properties p = new Properties();
        try {
            p.load(ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties"));
        } catch (Exception e) {
        }
        Configuration configuration = new Configuration();
        configuration.mergeProperties(p)
                //.addAnnotatedClass(User.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Registration.class);
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

}
