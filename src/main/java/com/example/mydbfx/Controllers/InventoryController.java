package com.example.mydbfx.Controllers;

import com.example.mydbfx.Models.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class InventoryController implements Initializable {
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
    public Button suppliersBtn;
    @FXML
    public Button logoutBtn;
    @FXML
    public VBox contentBox;
    public ObservableList<String> list;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        updateContentBox();
    }

    public void updateContentBox() {
        ResultSet result = Model.getInstance().getDatabaseDriver().runQuery("SELECT * FROM INVENTORY");
        ArrayList<String> table = Model.getInstance().getDatabaseDriver().toString(result);
        list = FXCollections.observableArrayList(table);
        ListView<String> items = new ListView<>();
        items.setItems(list);
        contentBox.getChildren().add(items);
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
        Stage stage = (Stage) suppliersBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showSuppliersWindow();
    }

    public void logoutBtnPressed(ActionEvent actionEvent) {
        Stage stage = (Stage) logoutBtn.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showLandingWindow();
    }
}
