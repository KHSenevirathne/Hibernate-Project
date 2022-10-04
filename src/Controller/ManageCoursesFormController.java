package Controller;

import bo.BOFactory;
import bo.custom.CourseBO;
import bo.custom.Impl.CourseBOImpl;
import dao.DAOFactory;
import dao.custom.RegisterDAO;
import dto.CourseDTO;
import entity.Course;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ManageCoursesFormController {
    public AnchorPane manageCoursesContext;
    public TextField txtProgramID;
    public TextField txtProgramName;
    public TextField txtDuration;
    public TextField txtFee;
    public TableView tblProgramDetails;
    public TableColumn colProgramID;
    public TableColumn colProgramName;
    public TableColumn colDuration;
    public TableColumn colFee;

    int selectedRow = -1;
    private CourseBO courseBO= (CourseBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.COURSE);

    ArrayList<CourseDTO> allCourses;

    public void initialize() throws Exception {
        allCourses= courseBO.getAllCourse();

        colProgramID.setCellValueFactory(new PropertyValueFactory<>("PID"));
        colProgramName.setCellValueFactory(new PropertyValueFactory<>("PName"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));
        tblProgramDetails.getItems().setAll(allCourses);

        tblProgramDetails.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
            selectedRow = (int) newValue;
        });
    }

    public void openStudentDetailFormOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/StudentDetailsForm.fxml");
        Parent load = FXMLLoader.load(resource);
        manageCoursesContext.getChildren().clear();
        manageCoursesContext.getChildren().add(load);
    }

    public void goToRegisterFormOnAction(MouseEvent mouseEvent) throws IOException {
        URL resource = getClass().getResource("../view/RegisterForm.fxml");
        Parent load = FXMLLoader.load(resource);
        manageCoursesContext.getChildren().clear();
        manageCoursesContext.getChildren().add(load);
    }

    public void addOnAction(ActionEvent actionEvent) throws Exception {
        try {
            if (!txtProgramID.getText().isEmpty() && !txtProgramName.getText().isEmpty() && !txtDuration.getText().isEmpty() && !txtFee.getText().isEmpty()) {
                CourseDTO courseDTO = new CourseDTO(txtProgramID.getText(), txtProgramName.getText(), txtDuration.getText(), txtFee.getText());
                courseBO.saveCourse(courseDTO);
                URL resource = getClass().getResource("../view/ManageCoursesForm.fxml");
                Parent load = FXMLLoader.load(resource);
                manageCoursesContext.getChildren().clear();
                manageCoursesContext.getChildren().add(load);
                new Alert(Alert.AlertType.CONFIRMATION, "Course details added successfully..!", ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Fill all fields and try again..!", ButtonType.OK).show();
            }
        }catch (Exception e){
            new Alert(Alert.AlertType.WARNING, "Course ID is already exists..!", ButtonType.OK).show();
        }
    }

    public void cancelOnAction(ActionEvent actionEvent) {
        txtProgramID.clear();
        txtProgramName.clear();
        txtDuration.clear();
        txtFee.clear();
    }

    public void deleteOnAction(ActionEvent actionEvent) throws Exception {
        try {
            if(selectedRow!=-1){
                CourseDTO courseDTO = allCourses.get(selectedRow);
                courseBO.deleteCourse(courseDTO.getPID());
                URL resource = getClass().getResource("../view/ManageCoursesForm.fxml");
                Parent load = FXMLLoader.load(resource);
                manageCoursesContext.getChildren().clear();
                manageCoursesContext.getChildren().add(load);
                new Alert(Alert.AlertType.CONFIRMATION, "Course details deleted successfully..!", ButtonType.OK).show();
            }else{
                new Alert(Alert.AlertType.WARNING, "Please select a row and try again..!", ButtonType.OK).show();
            }

        }catch (Exception e){
            new Alert(Alert.AlertType.WARNING, "Something went wrong..!", ButtonType.OK).show();
        }

    }
}
