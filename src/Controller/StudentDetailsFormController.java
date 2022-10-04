package Controller;

import bo.custom.Impl.CourseBOImpl;
import bo.custom.Impl.RegisterBOImpl;
import bo.custom.Impl.StudentBOImpl;
import dto.StudentDTO;
import dto.tm.CourseDetailsForStudent;
import entity.Course;
import entity.Student;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class StudentDetailsFormController {
    public AnchorPane studentDetailsContext;
    public TableView tblStudentDetails;
    public TableColumn colStudentID;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colNIC;
    public TableColumn colContact;
    public TableView tblCourse;
    public TableColumn colCourse;

    int selectedRow = -1;
    List<Student> students;

    public void initialize() throws Exception {

        students = new StudentBOImpl().getAll();
        colStudentID.setCellValueFactory(new PropertyValueFactory<>("sID"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colNIC.setCellValueFactory(new PropertyValueFactory<>("nIC"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));

        tblStudentDetails.getItems().setAll(students);

        tblStudentDetails.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            selectedRow = (int) newValue;

        });

    }

    public void openModifyCoursesFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ManageCoursesForm.fxml");
        Parent load = FXMLLoader.load(resource);
        studentDetailsContext.getChildren().clear();
        studentDetailsContext.getChildren().add(load);
    }

    public void goToRegisterFormOnAction(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/RegisterForm.fxml");
        Parent load = FXMLLoader.load(resource);
        studentDetailsContext.getChildren().clear();
        studentDetailsContext.getChildren().add(load);
    }

    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/MainPage.fxml");
        Parent load = FXMLLoader.load(resource);
        studentDetailsContext.getChildren().clear();
        studentDetailsContext.getChildren().add(load);
    }

    public void selectCourseOnAction(MouseEvent mouseEvent) throws Exception {
        try {
            Student student = students.get(selectedRow);
            ArrayList<Object[]> courseByStudent = new RegisterBOImpl().getCourseByStudent((student.getSID()));

            System.out.println(courseByStudent.toString());
            ObservableList<CourseDetailsForStudent> obLIst = FXCollections.observableArrayList();
            for (Object[] obj : courseByStudent) {
                obLIst.add(new CourseDetailsForStudent(obj[1].toString()));
            }
            colCourse.setCellValueFactory(new PropertyValueFactory<>("courseID"));

            tblCourse.getItems().setAll(obLIst);
        }catch (Exception e){}
    }
}
