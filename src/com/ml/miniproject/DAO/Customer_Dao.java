package com.ml.miniproject.DAO;

import java.util.List;

import com.ml.miniproject.pojo.Customer;

public interface Customer_Dao {
	public Customer fetchCustomer(long cid);
	public List<Customer> fetchAll();
}
