package ChatWindow;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Chat {
    @FXML
    public TextArea textArea;
    @FXML
    public TextField textField;

    public void send(ActionEvent actionEvent) {
        if (!textField.getText().equals("")) {
            if (!textArea.getText().equals("")) {
                textArea.appendText("\n");
            }
            textArea.appendText("User: " + textField.getText());
            textField.setText("");
        }
    }
}