package io.github.chiangkaishek327;

import io.github.chiangkaishek327.animated.control.label.AnimatedLabel;
import io.github.chiangkaishek327.animated.control.pane.PaneAnimationGroup.PaneAnimationDirection;
import io.github.chiangkaishek327.animated.control.tabpane.AnimatedTab;
import io.github.chiangkaishek327.animated.control.tabpane.AnimatedTabPane;
import io.github.chiangkaishek327.animated.util.OtherUtil;
import io.github.chiangkaishek327.fxframe.Frame;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class wewq extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Frame frame = new Frame();

        frame.getWindowFrameController().setTop(new Button());
        AnimatedLabel a = new AnimatedLabel();
        HBox hBox = new HBox(a);
        hBox.setAlignment(Pos.CENTER);
        frame.getWindowFrameController().setGraphic(hBox);
        new Thread(() -> {
            while (true) {
                OtherUtil.delayConviently(1000);
                Platform.runLater(() -> a.setText(String.valueOf(Math.random())));
            }
        }).start();
        frame.show();
    }

    @SuppressWarnings("all")
    public static void efwjnefwbi() {
        launch(null);
    }

}
