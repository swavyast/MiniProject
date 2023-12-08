package com.ml.miniproject.DAO;

import java.util.List;

import com.ml.miniproject.pojo.ShippingAddress;

public interface ShippingAddress_Dao {
	public void saveShippingAddress(ShippingAddress sa);
	public void updateShippingAddress(ShippingAddress sa);
	public void deleteShippingAddress(long cid);
	public void deleteAll();
	public ShippingAddress fetchShippingAddress(long cid);
	public List<ShippingAddress> fetchAll();
}
