package com.DOA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.BookOrder;

public class BookOrderDAOImp implements BookOrderDAO {

	private Connection conn;

	public BookOrderDAOImp(Connection conn) {
		super();
		this.conn = conn;
	}

	

	public boolean saveOrder(List<BookOrder> b) {
		boolean f = false;

		try {

			String sql = "INSERT INTO BOOKORDER(ORDERID,USER_NAME,EMAIL,ADDRESS,PHONE,BOOK_NAME,AUTHOR,PRICE,PAYMENT) VALUES(?,?,?,?,?,?,?,?,?)";
			conn.setAutoCommit(false);
			PreparedStatement ps = conn.prepareStatement(sql);
			for (BookOrder blist : b) {
				ps.setString(1, blist.getOrderid());
				ps.setString(2, blist.getUser_name());
				ps.setString(3, blist.getEmail());
				ps.setString(4, blist.getFullAddress());
				ps.setString(5, blist.getPhone());
				ps.setString(6, blist.getBook_name());
				ps.setString(7, blist.getAuthor());
				ps.setString(8, blist.getPrice());
				ps.setString(9, blist.getPayment());
				ps.addBatch();
			}

			int[] i = ps.executeBatch();
			conn.commit();
			f = true;
			conn.setAutoCommit(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}



	public List<BookOrder> getBookUser(String email) {
	     List<BookOrder> list=new ArrayList<BookOrder>();
	     BookOrder ord=null;
	     
		try {
		String sql="SELECT * FROM BOOKORDER WHERE EMAIL=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, email);
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			ord=new BookOrder();
			ord.setId(rs.getInt(1));
			ord.setOrderid(rs.getString(2));
			ord.setUser_name(rs.getString(3));
			ord.setEmail(rs.getString(4));
			ord.setAddress(rs.getString(5));
			ord.setPhone(rs.getString(6));
			ord.setBook_name(rs.getString(7));
			ord.setAuthor(rs.getString(8));
			ord.setPrice(rs.getString(9));
			ord.setPayment(rs.getString(10));
			list.add(ord);
		}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}



	public List<BookOrder> getAllOrder() {
		 List<BookOrder> list=new ArrayList<BookOrder>();
	     BookOrder ord=null;
		try {
			String sql="SELECT * FROM BOOKORDER";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ord=new BookOrder();
				ord.setId(rs.getInt(1));
				ord.setOrderid(rs.getString(2));
				ord.setUser_name(rs.getString(3));
				ord.setEmail(rs.getString(4));
				ord.setAddress(rs.getString(5));
				ord.setPhone(rs.getString(6));
				ord.setBook_name(rs.getString(7));
				ord.setAuthor(rs.getString(8));
				ord.setPrice(rs.getString(9));
				ord.setPayment(rs.getString(10));
				list.add(ord);
			}
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
	}

}
