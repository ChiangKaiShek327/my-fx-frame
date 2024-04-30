package io.github.chiangkaishek327;

import io.github.chiangkaishek327.fxframe.Frame;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ds extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Frame frame = new Frame();
        frame.getWindowFrameController().setTitle("TEST TITLE");
        frame.getWindowFrameController().setOnClose(e -> {
            System.out.println("close");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            System.exit(0);
        });
        ;
        BorderPane borderPane = new BorderPane(new Label("HELLO"));
        borderPane.getCenter().setStyle("-fx-font-size:50 ;-fx-text-fill: #00f;");
        frame.setFrameScene(new Scene(borderPane));
        frame.setStylesheet(Frame.STYLE_LIGHT);
        frame.show();
    }

    @SuppressWarnings("all")
    public static void efwjnefwbi() {
        launch(null);
    }

}
