import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
  @Override
  public void start(Stage primaryStage) throws Exception {
  try {

      FXMLLoader loader = new FXMLLoader(getClass().getResource("FrontPage.fxml"));
      Parent root = loader.load();

      Scene scene = new Scene(root);
      primaryStage.setScene(scene);
      primaryStage.show();
      primaryStage.setTitle("Paint App");
      primaryStage.setResizable(false);

  } catch (Exception e) {
    e.printStackTrace();
    }
  }

    public static void main(String[] args) throws Exception {
      launch(args);
    }

}
