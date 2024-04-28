import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.effect.Blend;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;

public class MainController {

  // Mouse Positionings
  private double lastX;
  private double lastY;
  private double currentX;
  private double currentY;

  private double brushStrokeWidth;
  private Color brushColor;
  private boolean eraser;
  private String shapeSelected;
  private boolean drawingShape = false;
  private Color shapeColor;
  private double shapeHeight;

  private Circle lCircle;
  private Rectangle lRectangle;

    @FXML
    private Canvas canvas;

    // color controls

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private ColorPicker shapeColorPicker;

    // 3d button converter

    @FXML
    private Button convertBtn;

    // Shape Selector

    @FXML
    private Circle circShape;

    @FXML
    private Ellipse ellipseShape;

    @FXML
    private Rectangle rectShape;

    @FXML
    private Rectangle squareShape;

    // brush controls

    @FXML
    private ImageView marker;

    @FXML
    private ImageView pBrush;

    @FXML
    private ImageView pencil;
    // brush size
    @FXML
    private Slider slider;


    @FXML
    void chooseColor(ActionEvent event) {
      eraser = false;
    }
    

    @FXML
    void circleShape(MouseEvent event) {
      drawingShape = true;
      shapeSelected = "CIRCLE";
    }

    @FXML
    void ellipseShape(MouseEvent event) {
      drawingShape = true;
      shapeSelected = "CIRCLE";
    }

    @FXML
    void rectShape(MouseEvent event) {
      drawingShape = true;
      shapeSelected = "RECTANGLE";
    }

    @FXML
    void sqShape(MouseEvent event) {
      drawingShape = true;
      shapeSelected = "RECTANGLE";
    }

    @FXML
    void canvasMouseDrag(MouseEvent event) {
        currentX = event.getX();
        currentY = event.getY();

        // distance moved
        double dx = currentX - lastX;
        double dy = currentY - lastY;
        
        canvas.getGraphicsContext2D().setLineWidth(brushStrokeWidth);

        if (!drawingShape) {
          canvas.getGraphicsContext2D().strokeLine(lastX, lastY, currentX, currentY);
          // Update last position
          lastX = currentX;
          lastY = currentY;
      }
    }

    @FXML
    void selectEraser(MouseEvent event) {
      eraser = true;
      drawingShape = false;
    }

    @FXML
    void canvasMousePressed(MouseEvent event) {

      lastX = event.getX();
      lastY = event.getY();
      brushStrokeWidth = slider.getValue();
      brushColor = colorPicker.getValue();
      shapeColor = shapeColorPicker.getValue();


      if (eraser) {
        canvas.getGraphicsContext2D().setStroke(Color.WHITE);
      } else {
        canvas.getGraphicsContext2D().setStroke(brushColor);
      }
    }

    @FXML 
    void canvasMouseReleased(MouseEvent event) {
      // currentX = event.getX();
      // currentY = event.getY();

      if (drawingShape) {
        
        double width = Math.abs(currentX - lastX);
        shapeHeight = Math.abs(currentY - lastY);
        System.out.println(shapeHeight + " " + width);
        canvas.getGraphicsContext2D().setFill(shapeColor);

        switch (shapeSelected) {
          case "CIRCLE" :
            canvas.getGraphicsContext2D().fillOval(lastX, lastY, width, shapeHeight);
            lCircle = new Circle(lastX, lastY, width);
          break;

          case "RECTANGLE" :
            canvas.getGraphicsContext2D().fillRect(lastX, lastY, width, shapeHeight);
            // lRectangle = new Rectangle(lastX, lastY, width, shapeHeight);
            lRectangle = new Rectangle(lastX, lastY, width, shapeHeight);
          break;

          default:
            System.out.println("Invalid shape selected");
          break;
        }
      // lastX = 0;
      // lastY = 0;
      
    }  
    
  }

    @FXML
    void convertTo3d(ActionEvent event) {
      if (lRectangle != null || lCircle != null && drawingShape) {
        canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        // canvas.getGraphicsContext2D().fillRect(lRectangle.getX(), lRectangle.getY(), lRectangle.getWidth(), lRectangle.getHeight());
        // 3d effect
        // canvas.getGraphicsContext2D().setFill(Color.DARKRED);
        // DropShadow effect = new DropShadow();
        // effect.setBlurType(BlurType.THREE_PASS_BOX);
        // effect.setWidth(15.57);
        // effect.setHeight(21.47);
        // effect.setRadius(10);
        // effect.setOffsetX(3);
        // effect.setOffsetY(5);
        // effect.setColor(Color.DARKRED);

            //a cool 3D effect
            Blend blend = new Blend();
            blend.setMode(BlendMode.MULTIPLY);

            DropShadow outerDropShadow = new DropShadow();
            outerDropShadow.setColor(Color.GRAY);
            outerDropShadow.setBlurType(BlurType.THREE_PASS_BOX);
            outerDropShadow.setWidth(20.57);
            outerDropShadow.setHeight(21.47);
            outerDropShadow.setRadius(10);
            outerDropShadow.setOffsetX(6);
            outerDropShadow.setOffsetY(6);

            InnerShadow innerShadow = new InnerShadow();
            innerShadow.setColor(Color.DARKGRAY);
            innerShadow.setOffsetX(-5);
            innerShadow.setOffsetY(-5);

            blend.setTopInput(outerDropShadow);
            blend.setBottomInput(innerShadow);

        // DropShadow dropShadow = new DropShadow();
        // dropShadow.setColor(Color.GRAY);
        // dropShadow.setBlurType((BlurType.THREE_PASS_BOX));
        // dropShadow.setWidth(20.57);
        // dropShadow.setHeight(21.47);
        // dropShadow.setRadius(10);
        // dropShadow.setOffsetX(6);
        // dropShadow.setOffsetY(6);

        // InnerShadow innerShadow = new InnerShadow();
        // innerShadow.setColor(Color.DARKGRAY);
        // innerShadow.setOffsetX(-5);
        // innerShadow.setOffsetY(-5);

        // canvas.getGraphicsContext2D().strokeRect(lRectangle.getX(), lRectangle.getY(), lRectangle.getWidth(), lRectangle.getHeight());
        // dropShadow.setInput(innerShadow);
        canvas.getGraphicsContext2D().setEffect(blend);
        if (shapeSelected == "RECTANGLE") {
          canvas.getGraphicsContext2D().fillRect(lRectangle.getX(), lRectangle.getY(), lRectangle.getWidth(), lRectangle.getHeight());
        } else {
          canvas.getGraphicsContext2D().fillOval(lCircle.getCenterX(), lCircle.getCenterY(), lCircle.getRadius(), shapeHeight );
        }

        // resetting
        canvas.getGraphicsContext2D().setEffect(null);
      }
    }


    @FXML
    void selectBrush(MouseEvent event) {
      drawingShape = false;
      eraser = false;
    }

    @FXML
    void selectMarker(MouseEvent event) {
      drawingShape = false;
      eraser = false;
    }

    @FXML
    void selectPencil(MouseEvent event) {
      drawingShape = false;
      eraser = false;
    }

    @FXML
    void setStroke() {}
}

