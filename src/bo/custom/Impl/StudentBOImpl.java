package bo.custom.Impl;

import bo.custom.StudentBO;
import dao.DAOFactory;
import dao.custom.RegisterDAO;
import dao.custom.StudentDAO;
import dao.custom.impl.StudentDAOImpl;
import dto.StudentDTO;
import entity.Student;

import java.util.List;

public class StudentBOImpl implements StudentBO {
    private StudentDAO studentDAO= (StudentDAO) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.STUDENT);

    @Override
    public boolean saveStudent(StudentDTO dto) throws Exception {
        return studentDAO.add(new Student(dto.getsID(),dto.getName(),dto.getnIC(),dto.getAddress(),dto.getContact(),dto.getdOfBirth(),dto.getAge()));
    }

    @Override
    public String newStudentID() throws Exception {

        String lastID = studentDAO.getLastStudentID();
        if (lastID == null) {
            return "S001";
        } else {
            int newID = Integer.parseInt(lastID.substring(1, 4)) + 1;
            if (newID < 10) {
                return "S00" + newID;
            } else if (newID < 100) {
                return "S0" + newID;
            } else {
                return "S" + newID;
            }
        }
    }

    public Student searchStudent(String nic) throws Exception {
        return studentDAO.searchStudent(nic);
    }

    public List<Student> getAll () throws Exception {
        return studentDAO.getAll();
    }
}
