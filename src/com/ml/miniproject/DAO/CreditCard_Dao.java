package com.ml.miniproject.DAO;

import java.util.List;

import com.ml.miniproject.pojo.CreditCard;

public interface CreditCard_Dao {
	public void saveCreditCard(CreditCard c);
	public void updateCreditCard(CreditCard c);
	public CreditCard fetchCreditCard(long cCardId);
	public List<CreditCard> fetchAll();
	public void deleteCreditCard(long cCardId);
}
