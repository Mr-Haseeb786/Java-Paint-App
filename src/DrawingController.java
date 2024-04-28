import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;

public class DrawingController {

  private double startX;
  private double startY;

    @FXML
    private Canvas canvasObj;// Remove the initialization, it will be injected by FXML

    private GraphicsContext gContext; // Add a private variable to store the GraphicsContext

    @FXML
    private void initialize() { // Add an initialize method to get the GraphicsContext
        gContext = canvasObj.getGraphicsContext2D();
    }

    @FXML
    void mouseDragged(MouseEvent event) {
      gContext.lineTo(event.getX(), event.getY());
      gContext.stroke();
      // gContext.moveTo(event.getX(), event.getY()); 
      System.out.println(event.getX() + " " + event.getY());
    }

    @FXML
    void mousePressed(MouseEvent event) { // Add a mousePressed handler to draw a dot on click
      startX = event.getX();
      startY = event.getY();
      gContext.moveTo(startX, startY);
    }
}