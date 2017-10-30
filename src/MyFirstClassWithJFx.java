/*
 * Annamarie Roger
 * roger@calpoly.edu
 * NGA - JavaFX Factory Design
 * CSC 307 - 01
 */
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class MyFirstClassWithJFx extends Application {
	Label label1;
	Button button1;
	Button addButton, subtractButton, multiplyButton;
	TextField text1;
	TextField text2;
	int answer = 0;
	/*enum Operation {
		ADD, SUBTRACT, MULTIPLY
	}*/
	CalculatorOperation currentOperation; 
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {	
		stage.setTitle("My First Stage Title!!  !");
		
		//initialize label
		label1 = new Label("Answer: ");
		
		//create a root, add stuff
		VBox root = new VBox();
		//root.getChildren().add(label1);
		
		//create a scene with dimensions
		Scene scene = new Scene(root, 400, 400);
		
		//set scene and show
		stage.setScene(scene);
		
		text1 = new TextField();
		text2 = new TextField();
		addButton = new Button("+");
		subtractButton = new Button("-");
		multiplyButton = new Button("*");
		
		button1 = new Button("Calculate");
		button1.setOnAction(new EventHandler<ActionEvent>() {
			
			public void handle(ActionEvent event) {
				System.out.println("Hello World!!!");
				String firstText = text1.getText();
				String secondText = text2.getText();
				if (firstText == null || secondText == null) {
					System.out.println("Wait, you need two numbers!");
				}
				else {
					answer = 0;
					label1.setText(Integer.toString(answer)); 
					// Have an abstract class Operation
					// Have AddOperation extend that.
					try {
						answer = currentOperation.calculate(Integer.parseInt(firstText), Integer.parseInt(secondText));
						String ans = "Answer: " + Integer.toString(answer);
						label1.setText(ans);
					}
					catch(Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		});
		
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("Adding");
				currentOperation = new AddOperation();//Operation.ADD;
			}
		});
		
		subtractButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("Subtracting");
				currentOperation = new SubtractOperation(); //Operation.SUBTRACT;
			}
		});
		
		multiplyButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("Multiplying");
				currentOperation = new MultiplyOperation(); //Operation.MULTIPLY;
			}
		});
		
		root.getChildren().addAll(text1, text2, addButton, subtractButton, multiplyButton, button1, label1);
		stage.show();
	}
}