package com.DOA;

import java.util.List;

import com.entity.BookOrder;

public interface BookOrderDAO {
	
	public boolean saveOrder(List<BookOrder> b);

	public List<BookOrder> getBookUser(String email);
	
	public List<BookOrder> getAllOrder();
	
}
