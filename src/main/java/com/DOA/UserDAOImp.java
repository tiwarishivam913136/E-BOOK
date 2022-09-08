package com.DOA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDAOImp implements UserDAO {

	private Connection conn;

	public UserDAOImp(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean userRegister(User us) {
		boolean f = false;
		try {
			String sql = "INSERT INTO USER(NAME,EMAIL,PHONE_NO,PASSWORD) VALUES(?,?,?,?)";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, us.getName());
			st.setString(2, us.getEmail());
			st.setString(3, us.getPhno());
			st.setString(4, us.getPassword());

			int rs = st.executeUpdate();
			System.out.println("success");
			if (rs == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public User login(String email, String password) {
		User us = null;
		try {
			String sql = "SELECT * FROM USER WHERE EMAIL=? AND PASSWORD=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				us = new User();
				us.setId(rs.getInt(1));
				us.setName(rs.getString(2));
				us.setEmail(rs.getString(3));
				us.setPhno(rs.getString(4));
				us.setPassword(rs.getString(5));
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return us;
	}

	public boolean checkPassword(int id, String pwd) {

		boolean f = false;

		try {

			String sql = "SELECT * FROM USER WHERE ID=? AND PASSWORD=? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, pwd);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean updateProfile(User us) {

		boolean f = false;
		try {
			String sql = "UPDATE USER SET NAME=?,EMAIL=?,PHONE_NO=? WHERE ID=?";
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, us.getName());
			st.setString(2, us.getEmail());
			st.setString(3, us.getPhno());
			st.setInt(4, us.getId());

			int rs = st.executeUpdate();
			System.out.println("success");
			if (rs == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;

	}

	public boolean checkUser(String email) {

		boolean f = true;
		try {
			String sql = "SELECT * FROM USER WHERE EMAIL=?";
			PreparedStatement st = conn.prepareStatement(sql);
		    st.setString(1, email);

			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				f=false;
			}
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;

	}

}
