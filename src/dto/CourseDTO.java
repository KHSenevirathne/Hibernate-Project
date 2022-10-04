package dto;

import entity.Registration;

import java.util.List;

public class CourseDTO {
    private String PID;
    private String PName;
    private String duration;
    private String fee;
    private List<Registration> registrationList;

    public CourseDTO(String PID, String PName, String duration, String fee, List<Registration> registrationList) {
        this.PID = PID;
        this.PName = PName;
        this.duration = duration;
        this.fee = fee;
        this.registrationList = registrationList;
    }

    public CourseDTO(String PID, String PName, String duration, String fee) {
        this.PID = PID;
        this.PName = PName;
        this.duration = duration;
        this.fee = fee;
    }

    public CourseDTO() {
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

    public List<Registration> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<Registration> registrationList) {
        this.registrationList = registrationList;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "PID='" + PID + '\'' +
                ", PName='" + PName + '\'' +
                ", duration='" + duration + '\'' +
                ", fee='" + fee + '\'' +
                ", registrationList=" + registrationList +
                '}';
    }
}
