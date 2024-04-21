package io.github.chiangkaishek327.fxframe;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.Parent;

public interface Controller {
    public Parent getAll();

    public void initialize();

    public void update();

    public String getTitle();

    public void setTitle(String title);

    public StringProperty titleProperty();

}
