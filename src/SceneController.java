import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;;

public class SceneController {
  private Stage stage;
  private Scene scene;
  private Parent root;

  // public void SwitchtoScene1(ActionEvent e) {
  //   try {
  //     root = FXMLLoader.load(getClass().getResource("FrontPage.fxml"));
  //     stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
  //     scene = new Scene(root);
  //     stage.setScene(scene);
  //     stage.show();

  //   } catch (IOException e1) {
  //     e1.printStackTrace();
  //   }
  // } 

  public void OpenColorPallete(ActionEvent e) {
    try {
      root = FXMLLoader.load(getClass().getResource("ColorPallete.fxml"));
      stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
      scene = new Scene(root);
      stage.setScene(scene);
      stage.show();
      
    } catch (IOException e1) {
      e1.printStackTrace();
    }
  } 
}
