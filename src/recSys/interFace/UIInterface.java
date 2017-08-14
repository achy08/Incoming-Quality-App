package recSys.interFace;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


 
 public class UIInterface extends Application {
 public static TableView table = new TableView();
 @Override // Override the start method in the Application class
 public void start(Stage primaryStage) {
 table.setStyle("-fx-background-color: silver;");
 HBox mainPane =new HBox(50);
 mainPane.setStyle("-fx-background-color: PURPLE;");
 mainPane.setPadding(new Insets(35,35,35,35));
 VBox vBox =new VBox(20);
 GridPane g1 =new GridPane(); GridPane g2 =new GridPane();
 g1.setStyle("-fx-background-color: pink;");
 g1.setPadding(new Insets(20,20,20,20));
 g1.setHgap(30); g1.setVgap(30);
 g2.setStyle("-fx-background-color: skyblue;");
 g2.setPadding(new Insets(20,20,20,20));
 g2.setHgap(30); g2.setVgap(30);
 TextField t1 =new TextField();
 g1.add(t1, 1, 0);
 Label l1 =new Label("Enter Part Number");
 l1.setFont(Font.font("Times New Roman",
		 FontWeight.BOLD, FontPosture.ITALIC, 15));
 g1.add(l1, 0, 0);
 Button b1 = new Button("           getPartInfo           ");
 b1.setStyle("-fx-background-color: yellow;");
 b1.setFont(Font.font("Times New Roman",
		 FontWeight.BOLD, FontPosture.ITALIC, 15));
 g1.add(b1, 2, 0);
 Label l2 =new Label("Project");
 l2.setFont(Font.font("Times New Roman",
		 FontWeight.BOLD, FontPosture.ITALIC, 15));
 g1.add(l2, 0, 1);
 TextField t2 =new TextField();
 g1.add(t2, 2, 1);
 Label l3 =new Label("Part Number");
 l3.setFont(Font.font("Times New Roman",
		 FontWeight.BOLD, FontPosture.ITALIC, 15));
 g1.add(l3, 0, 2);
 TextField t3 =new TextField();
 g1.add(t3, 2, 2);
 Label l4 =new Label("Part Name");
 l4.setFont(Font.font("Times New Roman",
		 FontWeight.BOLD, FontPosture.ITALIC, 15));
 g1.add(l4, 0, 3);
 TextField t4 =new TextField();
 g1.add(t4, 2, 3);
 Label l5 =new Label("Inspection Level");
 l5.setFont(Font.font("Times New Roman",
		 FontWeight.BOLD, FontPosture.ITALIC, 15));
 g1.add(l5, 0, 4);
 TextField t5 =new TextField();
 g1.add(t5, 2, 4);
 Label l6 =new Label("Enter Lot Number");
 l6.setFont(Font.font("Times New Roman",
		 FontWeight.BOLD, FontPosture.ITALIC, 15));
 g2.add(l6, 0, 0);
 TextField t6 =new TextField();
 g2.add(t6, 1, 0);
 Label l7 =new Label("Enter Lot Size");
 l7.setFont(Font.font("Times New Roman",
		 FontWeight.BOLD, FontPosture.ITALIC, 15));
 g2.add(l7, 0, 3);
 TextField t7 =new TextField();
 g2.add(t7, 1, 3);
 Label l8 =new Label("Sample Size for Inspection:");
 l8.setFont(Font.font("Times New Roman",
		 FontWeight.BOLD, FontPosture.ITALIC, 15));
 g2.add(l8, 0, 7);
 TextField t8 =new TextField();
 g2.add(t8, 1, 7);
 Label l9 =new Label("pcs");
 l9.setFont(Font.font("Times New Roman",
		 FontWeight.BOLD, FontPosture.ITALIC, 15));
 g2.add(l9, 1, 8);
 Label l10 =new Label("Enter Lot Status(OK/NG)");
 l10.setFont(Font.font("Times New Roman",
		 FontWeight.BOLD, FontPosture.ITALIC, 15));
 g2.add(l10, 0, 10);
 TextField t9 =new TextField();
 g2.add(t9, 1, 10);
 TableColumn projectCol = new TableColumn("Project");
 TableColumn partNumCol = new TableColumn("Part Number");
 TableColumn partNameCol = new TableColumn("Part Name");
 TableColumn inspectionLevelCol = new TableColumn("Inspection Level");
 table.getColumns().addAll(projectCol, partNumCol, partNameCol, inspectionLevelCol);
 vBox.getChildren().addAll(table,g1);
 mainPane.getChildren().addAll(g2,vBox);
 Scene scene = new Scene(mainPane, 640, 640);
 Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
 primaryStage.setMinHeight(primaryScreenBounds.getHeight());
 primaryStage.setMinWidth(primaryScreenBounds.getWidth());
 primaryStage.setX(primaryScreenBounds.getMinX());
 primaryStage.setY(primaryScreenBounds.getMinY());
 primaryStage.setWidth(primaryScreenBounds.getWidth());
 primaryStage.setHeight(primaryScreenBounds.getHeight());
 primaryStage.setTitle("recSys"); // Set the stage title
 primaryStage.setScene(scene); // Place the scene in the stage
 primaryStage.show(); // Display the stage
 }
 public static void main(String[] args){
	 launch(args);
 }
 }














