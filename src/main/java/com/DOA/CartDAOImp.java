package com.DOA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Cart;

public class CartDAOImp implements CartDAO {

	private Connection conn;

	public CartDAOImp(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addCart(Cart c) {
		boolean f = false;
		try {
			String sql = "INSERT INTO CART(BID,UID,BOOKNAME,AUTHOR,PRICE,TOTAL_PRICE) VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getBid());
			ps.setInt(2, c.getUid());
			ps.setString(3, c.getBookname());
			ps.setString(4, c.getAuthor());
			ps.setDouble(5, c.getPrice());
			ps.setDouble(6, c.getTotalprice());
			
			int i=ps.executeUpdate();
            if(i==1) {
            	f=true;
            }
            			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Cart> getBookByUser(int userId) {
		
		Cart b=null;
		List<Cart> list=new ArrayList<Cart>();
		double totalPrice=0.0;
		try {
			
			String sql="SELECT * FROM CART WHERE UID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, userId);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				b=new Cart();
				b.setCid(rs.getInt(1));
				b.setBid(rs.getInt(2));
				b.setUid(rs.getInt(3));
				b.setBookname(rs.getString(4));
				b.setAuthor(rs.getString(5));
				b.setPrice(rs.getDouble(6));
				
			    totalPrice=totalPrice+rs.getDouble(7);
			    b.setTotalprice(totalPrice);
			    
			    list.add(b);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		return list;
	}

	public boolean deleteBook(int bid,int uid,int cid) {
         
		boolean f=false;
		try {
			String sql="DELETE FROM CART WHERE BID=? AND UID=? AND CID=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, bid);
	        ps.setInt(2, uid);	
	        ps.setInt(3, cid);
			
			int i=ps.executeUpdate();
			if( i==1 ) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
		
		
		return f;
	}

}
