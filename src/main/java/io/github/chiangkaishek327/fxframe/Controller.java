package io.github.chiangkaishek327.fxframe;

import javafx.beans.property.StringProperty;
import javafx.scene.Parent;

public interface Controller {
    /**
     * hmmm... it's not a good name
     * 
     * @return the root of the controller (like a anchorPane)
     */
    public Parent getAll();

    /**
     * define your initalize method there, and it will be done automatically
     */
    public void initialize();

    /**
     * do this after something changed
     */
    public void update();

    /**
     * 
     * @return the title of the root
     */
    public String getTitle();

    /**
     * 
     * @param title the title of the root
     */
    public void setTitle(String title);

    /**
     * 
     * @return you know
     */
    public StringProperty titleProperty();

}
