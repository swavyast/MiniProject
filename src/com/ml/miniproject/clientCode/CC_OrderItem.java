package com.ml.miniproject.clientCode;

import com.ml.miniproject.DAO.DAO_Factory;
import com.ml.miniproject.DAO.OrderItem_Dao;
import com.ml.miniproject.pojo.Book;
import com.ml.miniproject.pojo.Order;
import com.ml.miniproject.pojo.OrderItem;

public class CC_OrderItem {
	public static void main(String[] args) {
		OrderItem_Dao oidao=DAO_Factory.getOrderItemDao();
		//Order Item Object
		OrderItem oitem=new OrderItem();
		oitem.setItemCost(0);
		oitem.setItemCount((short)1);
		oitem.setMyBook(new Book());
		oitem.setOrder(new Order());
		oitem.setShippingCost(0);
		oitem.setTotalCost(0);
		oidao.saveOrderItem(oitem);
	}

}
