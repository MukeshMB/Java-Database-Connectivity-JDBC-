package com.example.mydbfx.Controllers;

import com.example.mydbfx.Models.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;


public class OnboardingController {
    @FXML
    public Button profileBtn;
    @FXML
    public Button dailySalesReportBtn;
    @FXML
    public Button inventoryBtn;
    @FXML
    public Button onboardingBtn;
    @FXML
    public Button marketingListBtn;
    @FXML
    public Button logoutBtn;
    @FXML
    public TextField firstField;
    @FXML
    public TextField lastField;
    @FXML
    public TextField addressField;
    @FXML
    public TextField contactField;
    @FXML
    public TextField roleField;
    @FXML
    public TextField salaryField;
    @FXML
    public TextField dobField;
    @FXML
    public Button hiredBtn;
    @FXML
    public TextField ssnField;
    @FXML
    public TextField sexField;
    @FXML
    public Button fetchEmployeeBtn;
    @FXML
    public Button supplierBtn;


    public void profileBtnPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) profileBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showProfileWindow();
    }

    public void dailySalesReportBtnPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) profileBtn.getScene().getWindow();
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

    public void hiredBtnPressed(ActionEvent actionEvent) {
        String fname = firstField.getText();
        String lname = lastField.getText();
        String addr = addressField.getText();
        String contact = contactField.getText();
        String role = roleField.getText();
        String salary = salaryField.getText();
        String dob = dobField.getText();
        String sex = sexField.getText();
        String ssn = ssnField.getText();

        if(ssn.isEmpty()) {
            ssnField.setBackground(Background.fill(Color.RED));
        } else {
            String query = "INSERT INTO EMPLOYEES (EmployeeID, Username, Passwd, Fname, Lname, Occupation, Salary, Sex, DOB, ContactNumber, Address) VALUES " +
                    String.format("( %s, '', '', '%s', '%s', '%s', %s, '%s', '%s', '%s', '%s' )", ssn, fname, lname, role, salary, sex.trim(), dob, contact, addr);
            try {
                Model.getInstance().getDatabaseDriver().runDMLQuery(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void fetchEmployeeBtnPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showEmployeeListWindow();
    }

}
