package com.example.demo;
import java.sql.*;

import org.springframework.boot.autoconfigure.domain.EntityScan;

public class InnovacerBean {
	static Connection con;
	

	public  String returnCurrentVisitorMailId() {
		String currentMailId=null;
		try{  
			 
			Statement stmt=createStatement();
			ResultSet rs=stmt.executeQuery("select * from visitor");  
			while(rs.next())  
			
				currentMailId=rs.getString(2); 
			//con.close();
			
			}catch(Exception e){ System.out.println(e);}  
	return currentMailId;		
	}
	
public Statement createStatement()
{
	try {
		
	Class.forName("com.mysql.cj.jdbc.Driver");  
	con=DriverManager.getConnection(  
	"jdbc:mysql://localhost:3306/innovacer","root","Anmol@123");  
	//here sonoo is database name, root is username and password  
	Statement stmt=con.createStatement();
	return stmt;
	}catch(Exception e){
	System.out.println(e);
	}
	return null;
	
	
}
public void insertDetails(String name,String email,String phone,String time) {
	try {
		System.out.println("in innovacer");
		Statement stmt=createStatement();
		PreparedStatement statement =con.prepareStatement("Insert INTO visitor(name,email,phone,entry) values(?,?,?,?)");
		statement.setString(1, name);
		statement.setString(2, email);
		statement.setString(3,phone);
		statement.setString(4,time);
		statement.execute();
		System.out.println("done");
		con.close();
	}
	catch(Exception e)
	{
		
	}
	
	
}
}

