package Controller;

import bo.custom.Impl.CourseBOImpl;
import bo.custom.Impl.RegisterBOImpl;
import bo.custom.Impl.StudentBOImpl;
import bo.custom.RegisterBO;
import com.jfoenix.controls.JFXTextField;
import dto.CourseDTO;
import dto.RegisterDTO;
import dto.StudentDTO;
import entity.Course;
import entity.Registration;
import entity.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RegisterFormController {
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtDOB;
    public ComboBox<String> cmbCourseType;
    public Label lblSID;
    public AnchorPane registerFormContext;
    public TextField txtNIC;
    public TextField txtContact;
    public TextField txtAge;
    public JFXTextField txtSearch;

    ArrayList<String> courseNames = new ArrayList<>();
    Course course;

    public void initialize() throws Exception {
        String id = new StudentBOImpl().newStudentID();
        lblSID.setText(id);
        ArrayList<CourseDTO> courses = new CourseBOImpl().getAllCourse();
        for (CourseDTO c: courses) {
            courseNames.add(c.getPName());
        }
        cmbCourseType.getItems().setAll(courseNames);

        cmbCourseType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            try {
                if(!cmbCourseType.getSelectionModel().getSelectedItem().equals("null")){
                    course = new CourseBOImpl().searchCourse(cmbCourseType.getSelectionModel().getSelectedItem());
                    System.out.println(course.toString());
                }
            }catch(Exception e){}
        });
    }

    public void registerOnAction(ActionEvent actionEvent) throws Exception {
        try {
            if(!txtName.getText().isEmpty() && !txtNIC.getText().isEmpty() && !txtAddress.getText().isEmpty() && !txtContact.getText().isEmpty() && !txtDOB.getText().isEmpty() && !txtAge.getText().isEmpty()) {
                Date date = Date.valueOf(LocalDate.now());
                List<Course>  courseArrayList= new ArrayList<>();
                courseArrayList.add(course);
                Student student = new Student(lblSID.getText(), txtName.getText(), txtNIC.getText(), txtAddress.getText(), txtContact.getText(), txtDOB.getText(), txtAge.getText());


                if (!cmbCourseType.getSelectionModel().isEmpty()) {
                    System.out.println(courseArrayList.toString());
                    RegisterDTO registration = new RegisterDTO(lblSID.getText(),date,course.getFee(),student,courseArrayList);
                    System.out.println(registration.toString());
                    try {
                        boolean saved = new RegisterBOImpl().registerStudent(registration);
                        if (saved){
                            System.out.println("Saved");
                            new Alert(Alert.AlertType.CONFIRMATION,"Registration Successful",ButtonType.OK).show();
                            URL resource = getClass().getResource("../view/RegisterForm.fxml");
                            Parent load = FXMLLoader.load(resource);
                            registerFormContext.getChildren().clear();
                            registerFormContext.getChildren().add(load);
                        }
                    } catch (Exception e) {

                    }
                }else{
                    new Alert(Alert.AlertType.WARNING,"Please add program details",ButtonType.CLOSE).showAndWait();
                }
            }else{
                new Alert(Alert.AlertType.WARNING,"Error in registration process...!", ButtonType.OK).show();
            }
        }catch (Exception e){
            new Alert(Alert.AlertType.WARNING,"Something went wrong...!", ButtonType.OK).show();
        }

    }

    public void cancelOnAction(ActionEvent actionEvent) {
        txtName.clear();
        txtNIC.clear();
        txtContact.clear();
        txtAddress.clear();
        txtAge.clear();
        txtDOB.clear();
        cmbCourseType.getSelectionModel().clearSelection();
    }

    public void openStudentDetailFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/StudentDetailsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        registerFormContext.getChildren().clear();
        registerFormContext.getChildren().add(load);
    }

    public void openModifyCoursesOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/ManageCoursesForm.fxml");
        Parent load = FXMLLoader.load(resource);
        registerFormContext.getChildren().clear();
        registerFormContext.getChildren().add(load);
    }

    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/MainPage.fxml");
        Parent load = FXMLLoader.load(resource);
        registerFormContext.getChildren().clear();
        registerFormContext.getChildren().add(load);
    }

    public void searchStudents(ActionEvent actionEvent) throws Exception {
        searchStudentsOnAction(actionEvent);
    }

    public void searchStudentsOnAction(ActionEvent actionEvent) throws Exception {
        try {
            Student student = new StudentBOImpl().searchStudent(txtSearch.getText());

        if(student!=null) {
            txtName.setText(student.getName());
            txtNIC.setText(student.getNIC());
            txtAddress.setText(student.getAddress());
            txtAge.setText(student.getAge());
            txtDOB.setText(student.getdOfBirth());
            txtContact.setText(student.getContact());
        }else{
            new Alert(Alert.AlertType.WARNING,"Student is Not registered...!", ButtonType.OK).show();
        }
        }catch (Exception e){
            new Alert(Alert.AlertType.WARNING,"Student is Not registered...!", ButtonType.OK).show();
        }
    }
}
