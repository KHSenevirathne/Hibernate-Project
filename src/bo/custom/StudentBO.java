package bo.custom;

import bo.SuperBO;
import dto.StudentDTO;

public interface StudentBO extends SuperBO {
    public boolean saveStudent(StudentDTO dto) throws Exception;
    public String newStudentID() throws Exception;
}
