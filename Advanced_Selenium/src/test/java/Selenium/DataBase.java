package Selenium;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;

import com.mysql.cj.jdbc.Driver;


public class DataBase {
	public static void main(String[] args) throws SQLException {
		String expectedProjectName="INS_01";
		boolean flag=false;
		Driver driverRef=new Driver();
		DriverManager.registerDriver(driverRef);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","tiger");
		Statement stat=con.createStatement();
		ResultSet resultSet=stat.executeQuery("select * from project");
		while (resultSet.next()) {
			String actProjectName=resultSet.getString(4);
			if(expectedProjectName.equals(actProjectName)) {
				flag=true;
				System.out.println(" True ");
			}
		}
		if(flag==false) {
			System.out.println(" False ");
			Assert.fail();
		}
		con.close();
	}
}
