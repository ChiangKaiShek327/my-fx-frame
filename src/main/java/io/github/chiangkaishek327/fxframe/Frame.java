package io.github.chiangkaishek327.fxframe;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import io.github.chiangkaishek327.animatedfx.AnimatedPane;
import io.github.chiangkaishek327.animatedfx.AnimatedPane.MoveDirection;
import io.github.chiangkaishek327.fxframe.control.WindowFrameController;
import javafx.animation.FadeTransition;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class Frame extends Stage {
    static {
        Font.loadFont(Frame.class.getResourceAsStream("resource/BitterPro-Light.ttf"), 15);
    }

    WindowFrameController thisWindowFrameController;
    ObjectProperty<URL> styleProperty = new SimpleObjectProperty<>(STYLE_DARK);
    ObjectProperty<Duration> showingAnimationLengthProperty = new SimpleObjectProperty<>(Duration.seconds(0.2));
    Parent parent;
    Scene scene;
    public static final URL STYLE_DARK = Frame.class
            .getResource("resource/css-styles/dark/style.css"),
            STYLE_LIGHT = Frame.class.getResource("resource/css-styles/light/style.css");

    public Frame() throws IOException {
        thisWindowFrameController = (WindowFrameController) FXMLLoaderPP
                .load(Frame.class.getResource("resource/windowFrame.fxml"));

        parent = thisWindowFrameController.getAll();

        scene = new Scene(parent);
        initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);

        styleProperty.addListener((ob, o, n) -> {
            if (o != null && n != null) {
                scene.getStylesheets().remove(o.toExternalForm());

                scene.getStylesheets().add(n.toExternalForm());
            }
        });
        styleProperty.setValue(STYLE_DARK);
        showingProperty().addListener((ob, o, n) -> {
            if (n) {
                FadeTransition fd = new FadeTransition(showingAnimationLengthProperty.getValue(),
                        thisWindowFrameController.getAll());
                fd.setFromValue(0);
                fd.setToValue(1);
                fd.play();
            }
        });
        super.setScene(scene);
    }

    public WindowFrameController getWindowFrameController() {
        return thisWindowFrameController;
    }

    public void setFrameScene(Scene scene) {
        thisWindowFrameController.setGraphic(scene.getRoot());
    }

    public void setStylesheet(URL url) {
        styleProperty.setValue(url);
    }

    public URL getStylesheet() {
        return styleProperty.getValue();
    }

    public ObjectProperty<URL> stylesheetProperty() {
        return styleProperty;
    }

    public void setShowingAnimationLength(Duration duration) {
        showingAnimationLengthProperty.setValue(duration);
    }

    public Duration getShowingAnimationLength() {
        return showingAnimationLengthProperty.getValue();
    }

    public ObjectProperty<Duration> showingAnimationLengthProperty() {
        return showingAnimationLengthProperty;
    }
}
