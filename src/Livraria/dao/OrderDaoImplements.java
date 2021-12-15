package Livraria.dao;

import java.awt.List;
import java.sql.SQLException;

import Livraria.Order;

public interface OrderDaoImplements {
	
	void insert (Order obj) throws SQLException;
	void mofify (Order obj) throws SQLException;
	void delete(Order obj) throws SQLException;
	List show(Order obj) throws SQLException;
}
