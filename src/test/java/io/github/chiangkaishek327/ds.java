package io.github.chiangkaishek327;

import io.github.chiangkaishek327.animated.control.tabpane.AnimatedTab;
import io.github.chiangkaishek327.animated.control.tabpane.AnimatedTabPane;
import io.github.chiangkaishek327.fxframe.Frame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
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
        AnimatedTabPane atp = new AnimatedTabPane();
        atp.getTabs().add(new AnimatedTab("wdnkjlnkjlnkl", new BorderPane()));
        atp.getTabs().add(new AnimatedTab("wdnkjlnkjlnkl", new BorderPane()));
        atp.getTabs().add(new AnimatedTab("wdnkjlnkjlnkl", new BorderPane()));
        FXMLLoader f = new FXMLLoader(ds.class.getResource("text.fxml"));
        f.setBuilderFactory(new JavaFXBuilderFactory());
        f.load();
        frame.getWindowFrameController().setGraphic(f.getRoot());

        frame.getWindowFrameController().setTop(new Button());
        frame.show();
    }

    @SuppressWarnings("all")
    public static void efwjnefwbi() {
        launch(null);
    }

}
