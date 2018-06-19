package application;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class Dashboard {

	private BorderPane bpRoot;
	private Scene scene;
	private Stage primaryStage;
	private String bmwvin = "";
	private TextField tfVIN;
	private GridPane gpAutoReg;
	private RadioButton selectedRadioButton;
	private ObservableList<Bmw> data;
	private TextField tfCond;

	Dashboard(Stage primaryStage) {
		this.bpRoot = new BorderPane();
		scene = new Scene(this.bpRoot, 1300, 500);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

		this.primaryStage = primaryStage;

		this.primaryStage.setScene(scene);
		this.primaryStage.setTitle("AutoReg");
		this.primaryStage.setResizable(false);
		this.primaryStage.centerOnScreen();
		addElementsToScene();

		this.primaryStage.setScene(scene);
		this.primaryStage.show();
	}

	private void addElementsToScene() {
			Label lblVIN = new Label("VIN:");
			Label lblSeries = new Label("Series:");
			Label lblType = new Label("Type:");
			Label lblFuel = new Label("Fuel:");
			Label lblCond = new Label("Condition:");
			
			
			tfVIN = new TextField();
			tfCond = new TextField();
			
			CheckBox cb1 = new CheckBox();
			CheckBox cb2 = new CheckBox();
			CheckBox cb3 = new CheckBox();
			cb1.setText("Petrol");
			cb2.setText("Diesel");
			cb3.setText("LPG");
			
			cb1.setSelected(true);
			
			ToggleGroup group = new ToggleGroup();
			RadioButton rb1 = new RadioButton();
			RadioButton rb2 = new RadioButton();
			RadioButton rb3 = new RadioButton();
		
			rb1.setToggleGroup(group);
			rb2.setToggleGroup(group);
			rb3.setToggleGroup(group);
			
			rb1.setText("3 Series");
			rb2.setText("5 Series");
			rb3.setText("7 Series");
			rb1.setSelected(true);
			
			
			ToggleGroup type = new ToggleGroup();
			RadioButton rb4 = new RadioButton();
			RadioButton rb5 = new RadioButton();
			RadioButton rb6 = new RadioButton();
			
			rb4.setToggleGroup(type);
			rb5.setToggleGroup(type);
			rb6.setToggleGroup(type);
			
			rb4.setText("Sedan");
			rb5.setText("Wagon");
			rb6.setText("Coupe");
			rb4.setSelected(true);
			
			
		
			
	
			
			
			Button btnAdd = new Button("Add");
			btnAdd.setMinWidth(80);
			Button btnDelete = new Button("Delete");
			btnDelete.setMinWidth(80);
			Button btnUpdate = new Button("Update");
			btnUpdate.setMinWidth(80);
			Button btnSearch = new Button("Search");
			btnSearch.setMinWidth(80);
			
			
			/////////////////////////////////////////////////////////////////
			
			GridPane gpButtons = new GridPane();
			gpButtons.add(btnAdd,0,0);
			gpButtons.add(btnDelete,1,0);
			gpButtons.add(btnUpdate,2,0);
			gpButtons.add(btnSearch,3,0);
			
			
			
			
			
			
			TableView table = new TableView();	
			
			 table.setEditable(true);
			 TableColumn VINCol = new TableColumn("VIN");
			 VINCol.setMinWidth(20);
			 TableColumn SeriesCol = new TableColumn("Series");
			 SeriesCol.setMinWidth(100);
			 TableColumn TypeCol = new TableColumn("Type");
			 TypeCol.setMinWidth(100);
			 TableColumn FuelCol = new TableColumn("Fuel");
			 FuelCol.setMinWidth(50);
			 TableColumn ConditionCol = new TableColumn("Condition");
			 ConditionCol.setMinWidth(50);
			 
			 table.getColumns().addAll(VINCol, SeriesCol, TypeCol, FuelCol, ConditionCol);
		
			 table.setMaxHeight(350);
			 ObservableList<Bmw> data = FXCollections.observableArrayList();
			 	BmwDao bmwDao = new BmwDao();
			 	bmwDao.showBMW(data);
				table.setItems(data);
			 
			 GridPane gpSeries = new GridPane();
				gpSeries.addRow(1,rb1);
				gpSeries.addRow(2,rb2);
				gpSeries.addRow(3,rb3);
				
				
			
		
			GridPane gpFuel = new GridPane();
				gpFuel.add(cb1,1,1);
				gpFuel.add(cb2,1,2);
				gpFuel.add(cb3,1,3);
				
			GridPane gpType = new GridPane();
			gpType.addRow(1, rb4);
			gpType.addRow(2, rb5);
			gpType.addRow(3, rb6);
		
			
				
				gpAutoReg = new GridPane();
				gpAutoReg.add(lblVIN,0,0);
				gpAutoReg.add(tfVIN,1,0);
				gpAutoReg.add(lblSeries,0,1);
				gpAutoReg.add(gpSeries,1,1);
				gpAutoReg.add(lblFuel,0,2);
				gpAutoReg.add(gpFuel,1,2);
				gpAutoReg.add(lblType,0,3);
				gpAutoReg.add(gpType,1,3);
				gpAutoReg.add(lblCond, 0, 4);
				gpAutoReg.add(tfCond,1,4);
				gpAutoReg.add(gpButtons,0,7,2,1);
				gpAutoReg.setPadding(new Insets(10,10,10,10));
				gpAutoReg.setVgap(10);
				gpAutoReg.setHgap(10);
				
				bpRoot.setCenter(gpAutoReg);
				bpRoot.setRight(table);
				
				
				btnAdd.setOnAction(new EventHandler<ActionEvent>(){
					@Override
					public void handle(ActionEvent event){
						if(vin_validate("add")) {
							Bmw bmw = new Bmw(Integer.parseInt(tfVIN.getText()), selectedRadioButton.getText().toString(), bmwvin, selectedRadioButton.getText().toString(), tfCond.getText().toString());
							bmwDao.addBMW(bmw);
							table.getItems().clear();
							bmwDao.showBMW(data);
						}
					}
});
			
				}
				
				private boolean vin_validate(String action) {
					bmwvin ="";
					switch(action) {
					case "delete":
						if(Validation.isValidVIN(tfVIN.getText().toString())) {
							showAlert(Alert.AlertType.ERROR, gpAutoReg.getScene().getWindow(),"Form Klaida!","Neteisingas VIN formatas!");
							return false;
						}else return true;
						
						default:
							if(!Validation.isValidVIN(tfVIN.getText().toString())) {
								showAlert(Alert.AlertType.ERROR, gpAutoReg.getScene().getWindow(),"Form Klaida!", "Neteisingai ivestas VIN formatas!");
								return false;
							}else {
								
							}
					}return true;
				}

		private void showAlert(Alert.AlertType alertype, Window owner, String title, String message) {
			Alert alert = new Alert(alertype);
			alert.setTitle(title);
			alert.setHeaderText(null);
			alert.setContentText(message);
			alert.initOwner(owner);
			alert.show();
		}
	
	
}
