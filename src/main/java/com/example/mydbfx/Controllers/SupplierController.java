package com.example.mydbfx.Controllers;

import com.example.mydbfx.Models.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class SupplierController {
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
