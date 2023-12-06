package com.example.mydbfx.Controllers;

import com.example.mydbfx.Models.Model;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;


public class LandingController {
    public TextField userNameField;
    public TextField passwordField;
    public Button loginBtn;


    public void loginBtnPressed(MouseEvent mouseEvent) {
        String user = userNameField.getText();
        String passwd = passwordField.getText();

        if(!user.isEmpty() && !passwd.isEmpty()) {
            ResultSet result = Model.getInstance().getDatabaseDriver().runQuery("SELECT EmployeeID FROM EMPLOYEES WHERE Username = \"" + user + "\" AND Passwd = \"" + passwd + "\"");
            try {
                if(result.next()) {
                    Stage stage = (Stage) loginBtn.getScene().getWindow();
                    Model.getInstance().getViewFactory().closeStage(stage);
                    Model.getInstance().getViewFactory().showMenuHomeWindow();
                    Model.getInstance().getDatabaseDriver().setEmpId(result.getInt(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        userNameField.setBackground(Background.fill(Color.RED));
        passwordField.setBackground(Background.fill(Color.RED));
    }

}
