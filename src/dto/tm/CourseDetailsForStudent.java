package dto.tm;

public class CourseDetailsForStudent {
    private String courseID;

    public CourseDetailsForStudent(String courseID) {
        this.courseID = courseID;
    }

    public CourseDetailsForStudent() {
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    @Override
    public String toString() {
        return "CourseDetailsForStudent{" +
                "courseID='" + courseID + '\'' +
                '}';
    }
}
