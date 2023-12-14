package com.example.mydbfx.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class ViewFactory {
    public void createStage(FXMLLoader fxmlLoader, String winName) {
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle(winName);
        stage.getIcons().add(new Image(String.valueOf(getClass().getResource("/Images/After5_logo.png"))));
        stage.show();
    }

    public void showLandingWindow() {
        createStage(new FXMLLoader(getClass().getResource("/FXML/Landing.fxml")), "Login");
    }

    public void showMenuHomeWindow() {
        createStage(new FXMLLoader(getClass().getResource("/FXML/MenuHome.fxml")), "Home");
    }

    public void showProfileWindow() {
        createStage(new FXMLLoader(getClass().getResource("/FXML/Profile.fxml")), "Profile");
    }

    public void showDailySalesReportWindow() {
        createStage(new FXMLLoader(getClass().getResource("/FXML/DailySalesReport.fxml")), "Profile");
    }

    public void showInventoryWindow() {
        createStage(new FXMLLoader(getClass().getResource("/FXML/Inventory.fxml")), "Inventory");
    }

    public void showOnboardingWindow() {
        createStage(new FXMLLoader(getClass().getResource("/FXML/Onboarding.fxml")), "Onboarding");
    }

    public void showEmployeeListWindow() {
        createStage(new FXMLLoader(getClass().getResource("/FXML/EmployeeList.fxml")), "Employees");
    }

    public void showMarketingListWindow() {
        createStage(new FXMLLoader(getClass().getResource("/FXML/MarketingList.fxml")), "Marketing List");
    }

    public void showSuppliersWindow() {
        createStage(new FXMLLoader(getClass().getResource("/FXML/Supplier.fxml")), "Suppliers");
    }

    public void closeStage(Stage stage) {
        stage.close();
    }

}
