package application;




import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login {
	private BorderPane bpRoot;
	private Stage primaryStage;
	
	
	
	public Login(Stage primaryStage) {
		this.primaryStage = primaryStage;
		
		addElementsToScene();
		
		primaryStage.show();
	
}
	public void addElementsToScene (){
	
		
		
		primaryStage.setTitle("AutoReg");
		this.bpRoot = new BorderPane();
		Scene scene = new Scene(this.bpRoot,300,250);
		//butinai reikia sitos eilutes kad veiktu css
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		primaryStage.setResizable(false);
		primaryStage.centerOnScreen();
		Label lblUsername = new Label("Prisijungimo vardas:");
		TextField tfUsername = new TextField();
		Label lblPassword = new Label("Slaptazodis:");
		PasswordField pfPassword = new PasswordField();
		
		
		
		Button btnLogin = new Button("Prisijungti");
		btnLogin.setMinWidth(100);
		btnLogin.setAlignment(Pos.CENTER);
		
		/////////////////////////////
		btnLogin.setOnAction((ActionEvent e)->{
			Dashboard dashboard = new Dashboard(this.primaryStage);		
		});
		///////////////////////////////
		
		
		
		Button btnRegister = new Button("Registruotis");
		btnRegister.setMinWidth(100);
		btnRegister.setAlignment(Pos.CENTER);
		
		
		///////////////////////////
		btnRegister.setOnAction((ActionEvent e)->{
			Register registruotis = new Register(this.primaryStage);		
		});
		//////////////////////////////
		
		HBox hbLoginText = new HBox();
		
		//drop shadow effect
		DropShadow dropshadow = new DropShadow();
		dropshadow.setOffsetX(5);
		dropshadow.setOffsetY(5);
		
		
		hbLoginText.setPadding(new Insets(10,10,10,10));
		hbLoginText.setAlignment(Pos.CENTER);
		Text txtLogin = new Text("Prisijungimas");
		txtLogin.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
		txtLogin.setEffect(dropshadow);
	
		hbLoginText.getChildren().add(txtLogin);
		
		GridPane gpLogin = new GridPane();
		gpLogin.add(lblUsername,0,0);
		gpLogin.add(tfUsername,1,0);
		gpLogin.add(lblPassword,0,1);
		gpLogin.add(pfPassword,1,1);
		//gpLogin.add(lblMessage, 1, 2);
		gpLogin.add(btnLogin, 1, 3);
		gpLogin.add(btnRegister, 1, 4);
		gpLogin.setPadding(new Insets(10,10,10,10));
		gpLogin.setVgap(10);
		gpLogin.setHgap(10);
		
		//reflection for GridPane
		Reflection reflection = new Reflection();
		reflection.setFraction(1f);
		gpLogin.setEffect(reflection);
		
		//sudedam elementus i BorderPane konteineri
		
	
		
		
		bpRoot.setTop(hbLoginText);
		bpRoot.setCenter(gpLogin);

		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}
