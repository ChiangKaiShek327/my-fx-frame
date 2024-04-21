package io.github.chiangkaishek327.fxframe;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import io.github.chiangkaishek327.fxframe.control.WindowFrameController;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Frame extends Stage {
    static {
        Font.loadFont(Frame.class.getResourceAsStream("resource/BitterPro-Light.ttf"), 15);
    }
    WindowFrameController thisWindowFrameController;

    public Frame() throws IOException {
        super();

        System.out.println("efwuefwuefvweqvfwoebfwhqbefwhfioqewbfeqwhbefhqwiobqefwih");
        thisWindowFrameController = (WindowFrameController) FXMLLoaderPP
                .load(Frame.class.getResource("resource/windowFrame.fxml"));
        Scene scene = new Scene(thisWindowFrameController.getAll());
        initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        super.setScene(scene);
    }

    public WindowFrameController getWindowFrameController() {
        return thisWindowFrameController;
    }

    public void setFrameScene(Scene scene) {
        thisWindowFrameController.setGraphic(scene.getRoot());
    }

}
