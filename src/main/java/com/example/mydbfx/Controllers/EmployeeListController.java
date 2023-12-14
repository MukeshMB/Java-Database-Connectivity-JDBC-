package com.example.mydbfx.Controllers;

import com.example.mydbfx.Models.Employee;
import com.example.mydbfx.Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class EmployeeListController implements Initializable {
    public Button backBtn;
    public TableView<Employee> table;
    public TableColumn<Employee, String> employeeId;
    public TableColumn<Employee, String> fname;
    public TableColumn<Employee, String> lname;
    public TableColumn<Employee, String> role;
    public TableColumn<Employee, String> salary;
    public TableColumn<Employee, String> sex;
    public TableColumn<Employee, String> dob;
    public TableColumn<Employee, String> contacts;
    public TableColumn<Employee, String> address;
    public TextField employeeIdField;
    public Button deleteEmployeeBtn;
    private ObservableList<Employee> list;
    private final HashMap<String, Employee> employeeHashMap = new HashMap<>();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        employeeId.setCellValueFactory(new PropertyValueFactory<Employee, String>("employeeId"));
        fname.setCellValueFactory(new PropertyValueFactory<Employee, String>("fname"));
        lname.setCellValueFactory(new PropertyValueFactory<Employee, String>("lname"));
        role.setCellValueFactory(new PropertyValueFactory<Employee, String>("role"));
        salary.setCellValueFactory(new PropertyValueFactory<Employee, String>("salary"));
        sex.setCellValueFactory(new PropertyValueFactory<Employee, String>("sex"));
        dob.setCellValueFactory(new PropertyValueFactory<Employee, String>("dob"));
        contacts.setCellValueFactory(new PropertyValueFactory<Employee, String>("contacts"));
        address.setCellValueFactory(new PropertyValueFactory<Employee, String>("address"));
        updateContentBox();
    }

    public void updateContentBox() {
        ResultSet result = Model.getInstance().getDatabaseDriver().runQuery("SELECT EmployeeID, Fname, Lname, Occupation, Salary, Sex, DOB, ContactNumber, Address FROM Employees");
        ArrayList<String[]> res = Model.getInstance().getDatabaseDriver().toString(result);
        list = FXCollections.observableArrayList();
        for(String[] data:res) {
            list.add(new Employee(data[0], data[1], data[2], data[3], data[4], data[5], data[6], data[7], data[8]));
            employeeHashMap.put(data[0], list.getLast());
        }

        table.setItems(list);
    }

    public void deleteEmployeeBtnPressed(ActionEvent actionEvent) {
        if(employeeIdField.getText().isEmpty()) {
            employeeIdField.setBackground(Background.fill(Color.RED));
        } else {
            try {
                ResultSet result = Model.getInstance().getDatabaseDriver().runQuery("SELECT EmployeeID FROM Employees WHERE EmployeeID = \"" + employeeIdField.getText() + "\"");
                if(result.next()) {
                    String query = "DELETE FROM Employees WHERE EmployeeID = \"" + employeeIdField.getText() + "\"";
                    Model.getInstance().getDatabaseDriver().runDMLQuery(query);
                    list.remove(employeeHashMap.get(employeeIdField.getText()));
                    employeeIdField.setText("");
                    employeeIdField.setBackground(Background.fill(Color.WHITE));

                } else {
                    employeeIdField.setText("EmployeeID Doesnot Exists");
                    employeeIdField.setBackground(Background.fill(Color.RED));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void backBtnPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) backBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showOnboardingWindow();
    }
}
