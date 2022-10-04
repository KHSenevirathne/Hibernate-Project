package entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Registration {
    @Id
    private String regNo;
    private Date regDate;
    private String fee;
    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Course> courses;

    public Registration(String regNo, Date regDate, String fee, Student student, List<Course> courses) {
        this.regNo = regNo;
        this.regDate = regDate;
        this.fee = fee;
        this.student = student;
        this.courses = courses;
    }

    public Registration(String regNo, Date regDate, String fee, Student student) {
        this.regNo = regNo;
        this.regDate = regDate;
        this.fee = fee;
        this.student = student;
    }

    public Registration() {
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "regNo='" + regNo + '\'' +
                ", regDate=" + regDate +
                ", fee='" + fee + '\'' +
                ", student=" + student +
                ", courses=" + courses +
                '}';
    }
}
