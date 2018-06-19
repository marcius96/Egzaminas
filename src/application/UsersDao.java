package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;



public class UsersDao {
	
	public UsersDao() {
		User user = new User();
	}
		public void addUser(User user)
		{
			String sql = "INSERT INTO `users`"
					+ "(`username`, `password`, `email`)"
					+ " VALUES (?, ?, ?)";
			try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");
			PreparedStatement add = myConn.prepareStatement(sql);
			add.setString(1,user.getUsername());
			add.setString(2,user.getPassword());
			add.setString(3,user.getEmail());
			
		
			add.execute();
			add.close();
			}catch(Exception exc){
				
				exc.printStackTrace();
			
			}
		}

}


