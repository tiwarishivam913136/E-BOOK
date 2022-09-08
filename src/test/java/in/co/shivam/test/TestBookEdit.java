package in.co.shivam.test;

import java.sql.Connection;

import com.DOA.BookDAOImp;
import com.DataBase.DBConnection;
import com.entity.BookDetails;

public class TestBookEdit {

	
	public static void main(String[] args) {
		test();
	}
	
	public static void test() {
		int id=1;
		
		Connection conn=null;
		
		BookDAOImp dao=new BookDAOImp(DBConnection.getConn());
		
		BookDetails d=new BookDetails();
		d=dao.getBooKById(id);
		
		System.out.println(d.getBookName());
		System.out.println(d.getAuthor());
		System.out.println(d.getPrice());
		System.out.println(d.getBookCategory());
		System.out.println(d.getStatus());
		System.out.println(d.getPhotoname());
		System.out.println(d.getEmail());
	}
}
