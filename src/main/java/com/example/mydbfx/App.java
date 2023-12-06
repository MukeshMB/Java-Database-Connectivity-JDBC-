package com.example.mydbfx;

import com.example.mydbfx.Models.Model;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        Model.getInstance().getViewFactory().showLandingWindow();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
