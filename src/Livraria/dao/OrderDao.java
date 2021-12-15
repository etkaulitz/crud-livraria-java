package Livraria.dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import Livraria.Order;

public class OrderDao implements OrderDaoImplements{
	
	Connection conection = null;
	public void conectar() {
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "123");
		
		try {
			conection = DriverManager.getConnection(
				"jdbc:mariadb://127.0.0.1:3308/livraria", prop);
			conection.setAutoCommit(false);
			
	} 	catch (Exception e) {
			e.printStackTrace();
	}
	}
		
		
		
	//insert
	@Override
	public void insert (Order obj) throws SQLException {
		
		String query = "INSERT INTO livraria.order (user_id, book_id, shippinginfo_id, billingInfo_id)" 
		+ "VALUES (?, ?, ?, ?)";
		
		PreparedStatement prep= conection.prepareStatement (
				query, Statement.RETURN_GENERATED_KEYS);
		
		//como colocar o statement objeto da classe? exemplo: DO usuário
		prep.setString(1, obj.getUser());
		prep.setString(2, obj.getBook());
		prep.setString(3, obj.getShippingInfo());
		prep.setString(4, obj.getBillingInfo());
		prep.execute();
		
		conection.commit();
		
		conection.close();
	}
	
	//update
	@Override
	public void mofify(Order obj) throws SQLException {
		conectar();
		
		String query = "UPDATE INTO livraria.order " 
		+ "SET user_id = ?, book_id = ?, shippinginfo_id = ?, billingInfo_id = ?" 
		+ "WHERE  id = ?";
		
		PreparedStatement prep= conection.prepareStatement (
				query, Statement.RETURN_GENERATED_KEYS);
		prep.setString(1, obj.getUser());
		prep.setString(2, obj.getBook());
		prep.setString(3, obj.getShippingInfo());
		prep.setString(4, obj.getBillingInfo());
		prep.setInt(5, obj.getId());
		prep.execute();
		conection.commit();
		
		conection.close();
	}
		
	//delete
	@Override
	public void delete(Order obj) throws SQLException {
		conectar();
		
		String query = "DELETE INTO livraria.order " 
				+ "WHERE  id = ?";
		
		PreparedStatement prep= conection.prepareStatement (
				query, Statement.RETURN_GENERATED_KEYS);
		
		prep.setInt(1, obj.getId());
		prep.execute();
		conection.commit();
		
		conection.close();
	}

	//show
		@Override
		public List show(Order obj) throws SQLException {
			int idTemp = - 1;
			List <Order> listOrder = new ArrayList<>();
			
			String query = "SELECT * from livraria.order ";
			
			try {
				PreparedStatement prep= conection.prepareStatement (query);
				ResultSet lista = prep.executeQuery();
				
				while(lista.next()) {
					Order order = new Order();
					order.setUser(lista.getUser("user_id"));
					order.setBook(lista.getBook("book_id"));
					order.setShippingInfo(lista.getShippingInfo("shippingInfo_id"));
					order.setBillingInfo(lista.getBillingInfo("billingInfo_id"));
					listOrder.add(order);
				}
			}
			catch (SQLException e){
				e.printStackTrace();
			}
			return listOrder;
		}
	

}
