package in.co.shivam.test;

import java.sql.Connection;

import com.DOA.BookDAOImp;
import com.DataBase.DBConnection;
import com.entity.BookDetails;

public class BookDtlTest {
	
	public static void main(String[] args) {
		testbooks();
		
	}
	
   Connection conn = null;
	
	private static BookDAOImp model = new BookDAOImp(DBConnection.getConn());
	
	private static void testbooks() {
		
		BookDetails add=new BookDetails();
		add.setBookName("C");
		add.setAuthor("Balaguruswamy");
		add.setPrice("360");
		add.setBookCategory("New Book");
		add.setStatus("Active");
		add.setPhotoname("c.jpg");
		add.setEmail("aman123@gmail.com");
		
		boolean b=model.addBooks(add);
		System.out.println(b);
		
		
	}
	 

}
