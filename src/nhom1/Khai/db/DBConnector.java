package nhom1.khai.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import nhom1.khai.models.Employee;



public class DBConnector {
	private Connection con;
	private ResultSet rs;
	private Statement stm;
	public Connection getCon() {
		return con;
	}
	public ResultSet getRs() {
		return rs;
	}
	public Statement getStm() {
		return stm;
	}
	public DBConnector() {
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mediaone"
					+ "?autoReconnect=true&useSSL=false&zeroDateTimeBehavior=convertToNull"
					,"root","khailinh1997");
			stm=con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Employee checkEmployee(String id,String password) {
		try {
			String query ="select * from Human,Employee where Human.id = employee.id and Human.ID='"
					+id+"';";
			rs=stm.executeQuery(query);
			if(!rs.next()) return null;
			if(!rs.getString("password").equals(password)) return null;
			return new Employee(id,rs.getString("fullName"),rs.getString("telephoneNumber"),rs.getDouble("salary"),password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}

