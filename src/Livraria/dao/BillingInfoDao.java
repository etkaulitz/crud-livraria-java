package Livraria.dao;

import Livraria.BillingInfo;
import Livraria.Order;

public interface BillingInfoDao {

	void insert (BillingInfo obj);
	void update (BillingInfo obj);
	BillingInfo findById (BillingInfo id);
}
