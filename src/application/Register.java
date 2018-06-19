package application;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Register {
	private BorderPane root;
	private Stage primaryStage; 
	
	
	Register(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.root = new BorderPane();
		
		Scene scene = new Scene(this.root,1300,800);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		
		this.primaryStage.setScene(scene);
		this.primaryStage.setTitle("Registracija");
		this.primaryStage.setResizable(false);
		this.primaryStage.centerOnScreen();
		
		addElementsToScene();						
		primaryStage.show();
		
	}
	
	private void addElementsToScene (){
		Label lblUsername = new Label("Prisijungimo vardas:");
		TextField tfUsername = new TextField();
		
		HBox hbRegisterText = new HBox();
		
		//drop shadow effect
		DropShadow dropshadow = new DropShadow();
		dropshadow.setOffsetX(5);
		dropshadow.setOffsetY(5);
		
		
		hbRegisterText.setPadding(new Insets(10,10,10,10));
		hbRegisterText.setAlignment(Pos.CENTER);
		Text txtRegister = new Text("Vartotojo registracija");
		txtRegister.setFont(Font.font("Courier New", FontWeight.BOLD, 30));
		txtRegister.setEffect(dropshadow);
	
		hbRegisterText.getChildren().add(txtRegister);
		
		Label lblEmail = new Label("El.pastas:");
		TextField tfEmail = new TextField();
		
		Label lblPassword = new Label("Slaptažodis:");
		PasswordField pfPassword = new PasswordField();
		Label lblPassword1 = new Label("Pakartokite slaptažodi:");
		PasswordField pfPassword1 = new PasswordField();
		Button btnRegister = new Button("Registruotis");
		btnRegister.setMinWidth(100);
		btnRegister.setAlignment(Pos.CENTER);
		
		GridPane gpRegister = new GridPane();
		gpRegister.add(lblUsername,0,0);
		gpRegister.add(tfUsername,1,0);
		gpRegister.add(lblEmail,0,1);
		gpRegister.add(tfEmail,1,1);
		gpRegister.add(lblPassword,0,2);
		gpRegister.add(pfPassword,1,2);
		gpRegister.add(lblPassword1,0,3);
		gpRegister.add(pfPassword1,1,3);
		gpRegister.add(btnRegister, 1, 4);
		gpRegister.setPadding(new Insets(10,10,10,10));
		gpRegister.setVgap(10);
		gpRegister.setHgap(10);

		
		this.root.setCenter(gpRegister);
		
		btnRegister.setOnAction(new EventHandler<ActionEvent>(){
			public void handle(ActionEvent event){
			User useris = new User(tfUsername.getText().toString(),pfPassword.getText().toString(),tfEmail.getText().toString());
			UsersDao userDao = new UsersDao();
			userDao.addUser(useris);
			}
		});
		
		
		primaryStage.show();
	}
}
