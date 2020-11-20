package controller;

import com.sun.javafx.application.PlatformImpl;

import javafx.application.Platform;
import javafx.stage.Stage;
import view.CreazioneLegaScreenController;
import view.FXEnvironment;
//import view.MainScreenController;
import view.MainScreenController;

public class Main {

    public static void main(final String[] args) {
        PlatformImpl.startup(() -> {
        });
        final FXEnvironment environment = new FXEnvironment();
        final MainScreenController mainScreen = new MainScreenController(environment);
        final CreazioneLegaScreenController creazioneLegaScreen = new CreazioneLegaScreenController(environment);

        Platform.runLater(() -> {
            try {
                final Stage primaryStage = new Stage();
                primaryStage.setTitle("Fantacalcio");
                environment.start(primaryStage);
            } catch (Exception e) {
                System.out.println("Unable to load graphic environment.");
                e.printStackTrace();
            }
            mainScreen.show();
        });
    }

}