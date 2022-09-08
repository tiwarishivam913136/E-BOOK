package in.co.shivam.test;

import java.sql.Connection;

import com.DOA.UserDAOImp;
import com.DataBase.DBConnection;
import com.entity.User;

public class registerTest {
	
	public static void main(String[] args) {
	
		
		add();
	}
	
	
	
	Connection conn = null;
	
	private static UserDAOImp model = new UserDAOImp(DBConnection.getConn());
	
private static void add() {
	
	User  u = new User();
	
	u.setName("shivam");
	u.setEmail("shivam@gmail.com");
	u.setPhno("9039000662");
	u.setPassword("Shiv@123");
	
	model.userRegister(u);
	
}
	
	
}
