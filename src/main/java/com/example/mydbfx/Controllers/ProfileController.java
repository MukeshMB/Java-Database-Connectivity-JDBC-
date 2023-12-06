package com.example.mydbfx.Controllers;

import com.example.mydbfx.Models.Model;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ProfileController implements Initializable {
    @FXML
    private Button profileBtn;
    @FXML
    private Button dailySalesReportBtn;
    @FXML
    private Button inventoryBtn;
    @FXML
    private Button onboardingBtn;
    @FXML
    private Button marketingListBtn;
    @FXML
    private Button supplierBtn;
    @FXML
    private Button logoutBtn;
    @FXML
    private Text fname;
    @FXML
    private Text lname;
    @FXML
    private Text role;
    @FXML
    private Text salary;
    @FXML
    private Text sex;
    @FXML
    private Text dob;
    @FXML
    private Text contact;
    @FXML
    private Text addr;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ResultSet result = Model.getInstance().getDatabaseDriver().runQuery("SELECT Fname, Lname, Occupation, Salary, Sex, DOB, ContactNumber, Address FROM Employees WHERE EmployeeID = \"" + Model.getInstance().getDatabaseDriver().getEmpId() + "\"");
        try {
            if(result.next()) {
                fname.setText(result.getString(1));
                lname.setText(result.getString(2));
                role.setText(result.getString(3));
                salary.setText(result.getString(4));
                sex.setText(result.getString(5));
                dob.setText(result.getString(6));
                contact.setText(result.getString(7));
                addr.setText(result.getString(8));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void profileBtnPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) profileBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showProfileWindow();
    }

    public void dailySalesReportBtnPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) dailySalesReportBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showDailySalesReportWindow();
    }

    public void inventoryBtnPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) inventoryBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showInventoryWindow();
    }

    public void onboardingBtnPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) onboardingBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showOnboardingWindow();
    }

    public void marketingListBtnPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) marketingListBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showMarketingListWindow();
    }

    public void suppliersBtnPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) supplierBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showSuppliersWindow();
    }

    public void logoutBtnPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLandingWindow();
    }

}
