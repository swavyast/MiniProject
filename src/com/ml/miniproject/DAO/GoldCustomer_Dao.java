package com.ml.miniproject.DAO;

import java.util.List;

import com.ml.miniproject.pojo.GoldCustomer;

public interface GoldCustomer_Dao {
	public void saveGoldCustomer(GoldCustomer gc);
	public void updateGoldCustomer(GoldCustomer gc);
	public GoldCustomer fetchGoldCustomer(long cid);
	public List<GoldCustomer> fetchAll();
	public void deleteGoldCustomer(long cid);
	public void deleteAll();
}
