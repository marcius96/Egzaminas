package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javafx.collections.ObservableList;

public class BmwDao {
	public void addBMW(Bmw bmw) {
		String sql ="INSERT INTO `bmw`(`VIN`, `Series`, `Type`, `Fuel`, `Condition`) VALUES (?, ?, ?, ?, ?)";
		
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");
			PreparedStatement add = myConn.prepareStatement(sql);
			add.setInt(1,bmw.getVin());
			add.setString(2,bmw.getSeries());
			add.setString(3,bmw.getType());
			add.setString(4,bmw.getFuel());
			add.setString(5,bmw.getCondition());

		
			add.execute();
			add.close();
			}catch(Exception exc){
				exc.printStackTrace();
			
			}
		}
	
	public void showBMW(ObservableList<Bmw> data) {
		String query = "";
		String sql = "SELECT * FROM 'bmw'";
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");
			PreparedStatement add = myConn.prepareStatement(query);
			ResultSet rs = add.executeQuery();
			while(rs.next()) {
				data.add(new Bmw(rs.getInt("VIN"), rs.getString("Series"), rs.getString("Type"), rs.getString("Fuel"), rs.getString("Condition")));
				}
			}catch(Exception exc) {
				exc.printStackTrace();
			}
		
	}
	}


