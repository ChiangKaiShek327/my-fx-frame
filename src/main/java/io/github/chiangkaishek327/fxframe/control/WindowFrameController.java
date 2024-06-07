package io.github.chiangkaishek327.fxframe.control;

import javax.management.RuntimeErrorException;

import io.github.chiangkaishek327.animated.control.button.AnimatedButton;
import io.github.chiangkaishek327.animated.control.button.ButtonAnimationGroup.ButtonAnimationType;
import io.github.chiangkaishek327.fxframe.Controller;
import javafx.animation.AnimationTimer;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class WindowFrameController implements Controller {
    @FXML
    private StackPane StackPaneBg;
    @FXML
    private BorderPane BorderPaneAll;
    @FXML
    private BorderPane BorderPaneControl;

    @FXML
    private AnimatedButton ButtonClose, ButtonMax, ButtonMin, ButtonOptions;

    @FXML
    private HBox HBoxButtons;

    @FXML
    private Label LabelTitle;
    private Window thisWindow;
    private StringProperty titleProperty;
    private AnimationTimer updateTimer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            update();
        }

    };
    private ObjectProperty<EventHandler<ActionEvent>> maximizeProperty, minimizeProperty, closeProperty, optionProperty;
    private BooleanProperty ResizeVerticalProperty = new SimpleBooleanProperty(false),
            ResizeLeftHortonizalProperty = new SimpleBooleanProperty(false),
            ResizeRightHortonizalProperty = new SimpleBooleanProperty(false),
            ResizeLeftAllProperty = new SimpleBooleanProperty(false),
            ResizeRightAllProperty = new SimpleBooleanProperty(false),
            FullScreenProperty = new SimpleBooleanProperty(false);
    private DoubleProperty borderWidthProperty = new SimpleDoubleProperty(4.0);

    @Override
    public Parent getAll() {
        return StackPaneBg;

    }

    double mouseSenceX, mouseSenceY, negativeMouseSenceX, negativeMouseSenceY, windowWSX, windowWSY;

    @Override
    public void initialize() {
        maximizeProperty = ButtonMax.onActionProperty();
        minimizeProperty = ButtonMin.onActionProperty();
        closeProperty = ButtonClose.onActionProperty();
        optionProperty = ButtonOptions.onActionProperty();
        maximizeProperty = ButtonMax.onActionProperty();
        try {
            otherInit();
            resizeInit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void resizeInit() {
        ResizeVerticalProperty.addListener((ob, o, n) -> setCursor(n, Cursor.V_RESIZE));
        ResizeLeftHortonizalProperty.addListener((ob, o, n) -> setCursor(n, Cursor.H_RESIZE));
        ResizeRightHortonizalProperty.addListener((ob, o, n) -> setCursor(n, Cursor.H_RESIZE));
        ResizeLeftAllProperty.addListener((ob, o, n) -> setCursor(n, Cursor.NE_RESIZE));
        ResizeRightAllProperty.addListener((ob, o, n) -> setCursor(n, Cursor.SE_RESIZE));
        FullScreenProperty.addListener((ob, o, n) -> ((Stage) thisWindow).setFullScreen(n));
        BorderPaneAll.setOnMouseMoved(e -> {
            try {
                mouseSenceX = e.getScreenX() - thisWindow.getX();
                mouseSenceY = e.getScreenY() - thisWindow.getY();
                negativeMouseSenceX = thisWindow.getWidth() - mouseSenceX;
                negativeMouseSenceY = thisWindow.getHeight() - mouseSenceY;
                double bdw = borderWidthProperty.doubleValue();
                ResizeVerticalProperty.setValue(negativeMouseSenceY <= bdw);
                ResizeLeftHortonizalProperty.setValue(mouseSenceX <= bdw);
                ResizeRightHortonizalProperty.setValue(negativeMouseSenceX <= bdw);
                ResizeRightAllProperty
                        .setValue(ResizeVerticalProperty.getValue() && ResizeRightHortonizalProperty.getValue());
                ResizeLeftAllProperty
                        .setValue(ResizeVerticalProperty.getValue() && ResizeLeftHortonizalProperty.getValue());

            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }

        });
        BorderPaneAll.setOnMousePressed(e -> {
            windowWSX = thisWindow.getX() + thisWindow.getWidth();
            windowWSY = thisWindow.getY() + thisWindow.getHeight();

        });
        BorderPaneAll.setOnMouseDragged(e -> {
            if (ResizeRightHortonizalProperty.getValue()) {
                thisWindow.setWidth(e.getScreenX() - thisWindow.getX() + negativeMouseSenceX);
            }
            if (ResizeLeftHortonizalProperty.getValue()) {
                thisWindow.setX(e.getScreenX() - mouseSenceX);
                thisWindow.setWidth(windowWSX - thisWindow.getX());
            }
            if (ResizeVerticalProperty.getValue()) {
                thisWindow.setHeight(e.getScreenY() - thisWindow.getY() + negativeMouseSenceY);
            }
        });

    }

    @Override
    public void update() {
    }

    @Override
    public String getTitle() {
        return titleProperty.getValue();
    }

    public void setGraphic(Node node) {
        BorderPaneAll.setCenter(node);
    }

    public void setTitle(String title) {
        titleProperty.setValue(title);
    }

    @Override
    public StringProperty titleProperty() {
        return titleProperty;
    }

    private void setCursor(boolean isset, Cursor cursor) {
        if (isset)
            BorderPaneAll.setCursor(cursor);
        else
            BorderPaneAll.setCursor(Cursor.DEFAULT);
    }

    private void otherInit() throws Exception {

        {
            titleProperty = LabelTitle.textProperty();

            for (AnimatedButton button : new AnimatedButton[] { ButtonClose, ButtonMax, ButtonMin, ButtonOptions }) {
                button.setFocusTraversable(false);
                button.setAnimationType(ButtonAnimationType.BAT_TRANSLATE);
                button.setChangeScale(-3);

            }
        }
        {
            BorderPaneControl.setOnMouseEntered(e -> {
                BorderPaneControl.setCursor(Cursor.OPEN_HAND);
            });
            BorderPaneControl.setOnMousePressed(e -> {

                BorderPaneControl.setCursor(Cursor.CLOSED_HAND);
            });
            BorderPaneControl.setOnMouseDragged(e -> {

                thisWindow.setX(e.getScreenX() - mouseSenceX);
                thisWindow.setY(e.getScreenY() - mouseSenceY);
                thisWindow.setOpacity(0.9);
            });
            BorderPaneControl.setOnMouseReleased(e -> {
                BorderPaneControl.setCursor(Cursor.OPEN_HAND);
                thisWindow.setOpacity(1);
            });
        }
        AnimationTimer ut = new AnimationTimer() {

            @Override
            public void handle(long now) {
                Scene thisScene = BorderPaneAll.getScene();
                if (thisScene != null) {
                    thisWindow = thisScene.getWindow();
                    stop();
                }
            }
        };
        ut.start();
        updateTimer.start();
    }

    public ObjectProperty<EventHandler<ActionEvent>> onOptionProperty() {
        return optionProperty;
    }

    public ObjectProperty<EventHandler<ActionEvent>> onCloseProperty() {
        return closeProperty;
    }

    public ObjectProperty<EventHandler<ActionEvent>> onMaximizeProperty() {
        return maximizeProperty;
    }

    public ObjectProperty<EventHandler<ActionEvent>> onMinimizeProperty() {
        return minimizeProperty;
    }

    public EventHandler<ActionEvent> getOnOption() {
        return optionProperty.getValue();
    }

    public EventHandler<ActionEvent> getOnClose() {
        return closeProperty.getValue();
    }

    public EventHandler<ActionEvent> getOnMaximize() {
        return maximizeProperty.getValue();
    }

    public EventHandler<ActionEvent> getOnMinimize() {
        return minimizeProperty.getValue();
    }

    public void setOnOption(EventHandler<ActionEvent> eventHandler) {
        optionProperty.setValue(eventHandler);
    }

    public void setOnClose(EventHandler<ActionEvent> eventHandler) {
        closeProperty.setValue(eventHandler);
    }

    public void setOnMaximize(EventHandler<ActionEvent> eventHandler) {
        maximizeProperty.setValue(eventHandler);
    }

    public void setOnMinimize(EventHandler<ActionEvent> eventHandler) {
        minimizeProperty.setValue(eventHandler);
    }

    public DoubleProperty borderWidthProperty() {
        return borderWidthProperty;
    }

    public double getBorderWidth() {
        return borderWidthProperty.doubleValue();
    }

    public void setBorderWidth(double borderWidth) {
        borderWidthProperty.setValue(borderWidth);
    }

    public void setTop(Node top) {
        BorderPaneAll.setTop(top);
    }

    public Node getTop() {
        return BorderPaneAll.getTop();
    }
}
