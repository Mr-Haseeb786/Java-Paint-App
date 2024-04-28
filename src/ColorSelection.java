import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ColorSelection {

    @FXML
    private Button colorBlue;

    @FXML
    private Button colorGreen;

    @FXML
    private Button colorRed;

    @FXML
    void colorSelected(ActionEvent event) {

        System.out.println("Color Selected: ");
    }

}
