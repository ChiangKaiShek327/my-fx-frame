package io.github.chiangkaishek327;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TL {

    @FXML
    private TableColumn<testclass, String> tc;

    @FXML
    private TableColumn<testclass, String> tc1;

    @FXML
    private TableView<testclass> tv;

    public void initialize() {
        System.out.println("wenjnkwwefkj");
        tc.setCellValueFactory(e -> e.getValue().sp0);
        tc1.setCellValueFactory(e -> e.getValue().sp1);
        for (int i = 0; i < 100; i++) {
            tv.getItems().add(new testclass());
        }
    }

    public class testclass {
        public StringProperty sp0 = new SimpleStringProperty("3efnjbfihwebefjbj");
        public StringProperty sp1 = new SimpleStringProperty("wdkdnenwdoiowee");
    }
}
