package com.ml.miniproject.DAO;

import java.util.List;

import com.ml.miniproject.pojo.OrderItem;

public interface OrderItem_Dao {
	public void saveOrderItem(OrderItem oi);
	public void updateOrderItem(OrderItem oi);
	public void deleteOrderItem(long orderId);
	public void deleteAll();
	public OrderItem fetchOrderItem(long orderId);
	public List<OrderItem> fetchAll();
}
