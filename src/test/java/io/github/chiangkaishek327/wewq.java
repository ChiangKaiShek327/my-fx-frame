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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class wewq extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Frame frame = new Frame();
        frame.getWindowFrameController().setTitle("XI JIN PING");
        frame.getWindowFrameController().setTop(new Button("RAISE YOUR HAND UP IF YOU DON'T AGREE"));
        frame.getWindowFrameController()
                .setGraphic(new ImageView(new Image(getClass().getResourceAsStream("xijinping.png"))));
        frame.show();
    }

    @SuppressWarnings("all")
    public static void efwjnefwbi() {
        launch(null);
    }

}
