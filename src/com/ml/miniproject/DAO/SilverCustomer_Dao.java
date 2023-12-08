package com.ml.miniproject.DAO;

import java.util.List;

import com.ml.miniproject.pojo.SilverCustomer;

public interface SilverCustomer_Dao {
	public void saveSilverCustomer(SilverCustomer sc);
	public void updateSilverCustomer(SilverCustomer sc);
	public SilverCustomer fetchSilverCustomer(long cid);
	public List<SilverCustomer> fetchAll();
	public void deleteSilverCustomer(long cid);
	public void deleteAll();
}
