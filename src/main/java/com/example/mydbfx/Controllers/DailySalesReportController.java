package com.example.mydbfx.Controllers;

import com.example.mydbfx.Models.Model;
import com.example.mydbfx.Models.Purchase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DailySalesReportController implements Initializable {
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
    public Button supplierBtn;
    @FXML
    public Button logoutBtn;
    @FXML
    public TableView<Purchase> table;
    @FXML
    public TableColumn<Purchase, String> purchaseId;
    @FXML
    public TableColumn<Purchase, String> date;
    public TableColumn<Purchase, String> customerName;
    public TableColumn<Purchase, String> itemName;
    public TableColumn<Purchase, String> price;
    public TableColumn<Purchase, String> employeeName;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        purchaseId.setCellValueFactory(new PropertyValueFactory<Purchase, String>("purchaseId"));
        date.setCellValueFactory(new PropertyValueFactory<Purchase, String>("date"));
        customerName.setCellValueFactory(new PropertyValueFactory<Purchase, String>("customerName"));
        itemName.setCellValueFactory(new PropertyValueFactory<Purchase, String>("itemName"));
        price.setCellValueFactory(new PropertyValueFactory<Purchase, String>("price"));
        employeeName.setCellValueFactory(new PropertyValueFactory<Purchase, String>("employeeName"));
        updateContentBox();
    }

    public void updateContentBox() {
        String query = "SELECT " +
                "purchase.PurchaseID AS pid, purchase.PurchaseDate AS pdate, " +
                "customer.CFname AS fname, " +
                "inventory.ClothingType AS itemname, inventory.Price AS price," +
                "employees.Fname AS empname " +
                "FROM Purchase " +
                "JOIN customer ON Purchase.CustomerID = customer.CustomerID " +
                "JOIN inventory ON Purchase.ItemID = inventory.ItemID " +
                "JOIN employees ON Purchase.EmployeeID = employees.EmployeeID";
        ResultSet result = Model.getInstance().getDatabaseDriver().runQuery(query);
        ArrayList<String[]> res = Model.getInstance().getDatabaseDriver().toString(result);
        ObservableList<Purchase> list = FXCollections.observableArrayList();
        for(String[] data:res) {
            list.add(new Purchase(data[0], data[1], data[2], data[3], data[4], data[5]));
        }

        table.setItems(list);
    }

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

}
