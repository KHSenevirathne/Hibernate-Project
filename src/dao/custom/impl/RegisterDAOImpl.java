package dao.custom.impl;

import dao.custom.RegisterDAO;
import entity.Course;
import entity.Registration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import util.FactoryConfiguration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegisterDAOImpl implements RegisterDAO {

    @Override
    public boolean add(Registration registration) throws SQLException, ClassNotFoundException {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(registration);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public ArrayList<Object[]> getCourseByStudent(String nic) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        //NativeQuery sqlQuery = session.createSQLQuery("SELECT * FROM registration_course WHERE registrationList_regNo =:SID");
        NativeQuery query = session.createSQLQuery("SELECT r.fee,rc.courses_PID FROM Registration r INNER JOIN Registration_course rc WHERE r.regNo = :studentId and rc.registrationList_regNo=r.regNo");

        //session.createQuery("SELECT s.id,s.name,s.address,s.contact,s.age,r.regNo,rd.Course_ID,c.program FROM Student s INNER JOIN Registration r INNER JOIN Registration_Details rd,Course c WHERE s.id = :studentId and r.Student_ID=s.id and r.regNo=rd.Reg_ID and c.programId=rd.Course_ID");
        query.setParameter("studentId", nic);
        List<Object[]> list = query.list();
        //List list = sqlQuery.list();

        //System.out.println(list.toString());

        //List<String> courseList = null;
        /*for (String course : list) {
            courseList.addAll(list);
        }*/
        transaction.commit();
        session.close();
        return (ArrayList<Object[]>)list;
    }
}
