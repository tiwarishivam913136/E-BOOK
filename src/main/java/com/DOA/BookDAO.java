package com.DOA;

import java.util.List;

import com.entity.BookDetails;

public interface BookDAO {
	
	public boolean addBooks(BookDetails b);
	
	public List<BookDetails> getAllBooks();
	
	public BookDetails getBooKById(int id);
	
	public boolean updateEditBooks(BookDetails b);
	
	public boolean deleteBooks(int id);
	
	public List<BookDetails> getnewBooks();
	
	public List<BookDetails> getrecentBooks();
	
	public List<BookDetails> getoldBooks();
	
	public  List<BookDetails> allRecentBook();
	
	public  List<BookDetails> allNewBook();
	
	public  List<BookDetails> allOldBook();
	
	public List<BookDetails> getBookByOld(String email,String cato);
	
    public boolean deleteOldBook(String email,String cato,int bid);
    
    public List<BookDetails> getBookBySearch(String ch);

}
