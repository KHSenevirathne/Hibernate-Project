package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Course {
    @Id
    private String PID;
    private String PName;
    private String duration;
    private String fee;
    @ManyToMany(mappedBy = "courses")
    private List<Registration> registrationList;

    public Course(String PID, String PName, String duration, String fee) {
        this.PID = PID;
        this.PName = PName;
        this.duration = duration;
        this.fee = fee;
    }

    public Course() {
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID;
    }

    public String getPName() {
        return PName;
    }

    public void setPName(String PName) {
        this.PName = PName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Course{" +
                "PID='" + PID + '\'' +
                ", PName='" + PName + '\'' +
                ", duration='" + duration + '\'' +
                ", fee='" + fee + '\'' +
                '}';
    }
}
