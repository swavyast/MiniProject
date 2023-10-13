package com.ml.miniproject.clientCode;

import java.util.Date;

import com.ml.miniproject.DAO.CreditCard_Dao;
import com.ml.miniproject.DAO.DAO_Factory;
import com.ml.miniproject.pojo.CreditCard;
import com.ml.miniproject.pojo.SilverCustomer;

public class CC_CreditCard {
public static void main(String[] args) {
	CreditCard_Dao cdao=DAO_Factory.getCreditCardDao();
	//Credit Card Object
	CreditCard mycard=new CreditCard();
	mycard.setCardType("Silver");
	mycard.setcCardNumber(45893567124638L);
	mycard.setCustomer(new SilverCustomer());
	mycard.setCvv((short)369);
	mycard.setExpDate(new Date());
	mycard.setStatus("Active");
	cdao.saveCreditCard(mycard);
}
}
