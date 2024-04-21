package io.github.chiangkaishek327.fxframe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXMLLoaderPP {

    public static Controller load(URL fxml, ResourceBundle resource) throws IOException {

        FXMLLoader loader = new FXMLLoader(fxml,
                resource);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.load();
        return loader.getController();

    }

    public static Controller load(URL fxml) throws IOException {

        FXMLLoader loader = new FXMLLoader(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.load();
        return loader.getController();

    }

    public static Controller openSimpleWindow(Controller controller, Stage stage) {
        Scene scene = new Scene(controller.getAll());
        scene.setFill(Paint.valueOf("#0000"));
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
        return controller;
    }
}
