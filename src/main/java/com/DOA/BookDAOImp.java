package com.DOA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.BookDetails;

public class BookDAOImp implements BookDAO {

	private Connection conn;

	public BookDAOImp(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addBooks(BookDetails b) {
		boolean f = false;
		try {
			String sql = "INSERT INTO BOOKDTLS(BOOK_NAME,AUTHOR,PRICE,BOOKCATEGORY,STATUS,PHOTO,USER_EMAIL) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getPrice());
			ps.setString(4, b.getBookCategory());
			ps.setString(5, b.getStatus());
			ps.setString(6, b.getPhotoname());
			ps.setString(7, b.getEmail());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
				System.out.println("success");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<BookDetails> getAllBooks() {

		List<BookDetails> list = new ArrayList<BookDetails>();
		BookDetails b = null;
		try {

			String sql = "SELECT * FROM BOOKDTLS";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new BookDetails();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;
	}

	public BookDetails getBooKById(int id) {

		BookDetails b = null;
		try {
			String sql = "SELECT * FROM BOOKDTLS WHERE BOOKID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BookDetails();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setEmail(rs.getString(8));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return b;
	}

	public boolean updateEditBooks(BookDetails b) {
		boolean f = false;
		try {
			String sql = "UPDATE BOOKDTLS SET BOOK_NAME=?,AUTHOR=?,PRICE=?,STATUS=? WHERE BOOKID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getPrice());
			ps.setString(4, b.getStatus());
			ps.setInt(5, b.getBookId());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public boolean deleteBooks(int id) {
		boolean f = false;
		try {
			String sql = "DELETE FROM BOOKDTLS WHERE BOOKID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<BookDetails> getnewBooks() {

		List<BookDetails> list = new ArrayList<BookDetails>();
		BookDetails b = null;
		try {

			String sql = "SELECT * FROM BOOKDTLS WHERE STATUS=? AND BOOKCATEGORY=? ORDER BY BOOKID DESC ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");
			ps.setString(2, "New");

			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 4) {
				b = new BookDetails();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<BookDetails> getrecentBooks() {

		List<BookDetails> list = new ArrayList<BookDetails>();
		BookDetails b = null;
		try {

			String sql = "SELECT * FROM BOOKDTLS WHERE STATUS=? ORDER BY BOOKID DESC ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");

			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 4) {
				b = new BookDetails();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<BookDetails> getoldBooks() {
		List<BookDetails> list = new ArrayList<BookDetails>();
		BookDetails b = null;
		try {

			String sql = "SELECT * FROM BOOKDTLS WHERE STATUS=? AND BOOKCATEGORY=? ORDER BY BOOKID DESC ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");
			ps.setString(2, "Old");

			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 4) {
				b = new BookDetails();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<BookDetails> allRecentBook() {

		List<BookDetails> list = new ArrayList<BookDetails>();
		BookDetails b = null;
		try {

			String sql = "SELECT * FROM BOOKDTLS WHERE STATUS=? ORDER BY BOOKID DESC ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new BookDetails();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<BookDetails> allNewBook() {

		List<BookDetails> list = new ArrayList<BookDetails>();
		BookDetails b = null;
		try {

			String sql = "SELECT * FROM BOOKDTLS WHERE STATUS=? AND BOOKCATEGORY=? ORDER BY BOOKID DESC ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");
			ps.setString(2, "New");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BookDetails();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<BookDetails> allOldBook() {
		List<BookDetails> list = new ArrayList<BookDetails>();
		BookDetails b = null;
		try {

			String sql = "SELECT * FROM BOOKDTLS WHERE STATUS=? AND BOOKCATEGORY=? ORDER BY BOOKID DESC ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "Active");
			ps.setString(2, "Old");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new BookDetails();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<BookDetails> getBookByOld(String email, String cato) {

		List<BookDetails> list = new ArrayList<BookDetails>();
		BookDetails b = null;
		try {

			String sql = "SELECT * FROM BOOKDTLS WHERE BOOKCATEGORY=? AND USER_EMAIL=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, cato);
			ps.setString(2, email);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BookDetails();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public boolean deleteOldBook(String email, String cato, int bid) {

		boolean f = false;

		try {
			String sql = "DELETE FROM BOOKDTLS WHERE BOOKCATEGORY=? AND USER_EMAIL=? AND BOOKID=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, cato);
			ps.setString(2, email);
			ps.setInt(3, bid);

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<BookDetails> getBookBySearch(String ch) {

		List<BookDetails> list = new ArrayList<BookDetails>();
		BookDetails b = null;
		try {

			String sql = "SELECT * FROM BOOKDTLS WHERE BOOK_NAME LIKE ? OR AUTHOR LIKE ? OR BOOKCATEGORY LIKE ? AND STATUS=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, "%"+ch+"%");
			ps.setString(2, "%"+ch+"%");
			ps.setString(3, "%"+ch+"%");
			ps.setString(4, "Active");
			

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BookDetails();
				b.setBookId(rs.getInt(1));
				b.setBookName(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCategory(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhotoname(rs.getString(7));
				b.setEmail(rs.getString(8));
				list.add(b);
				
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
