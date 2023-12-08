package com.ml.miniproject.DAO;

import java.util.List;

import com.ml.miniproject.pojo.Order;

public interface Order_Dao {
	public void saveOrder(Order o);
	public void upateOrder(Order o);
	public void deleteOrder(long oid);
	public void deleteAll();
	public Order fetchOrder(long oid);
	public List<Order> fetchAll();
}
