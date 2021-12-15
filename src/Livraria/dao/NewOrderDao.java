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

public class NewOrderDao implements OrderDaoImplements{
	
	private Connection conection = null;
	
	public void conectar() {
		Properties prop = new Properties();
		prop.setProperty("user", "root");
		prop.setProperty("password", "123");
		
		try {
			conection = DriverManager.getConnection(
				"jdbc:mariadb://127.0.0.1:3306/livraria", prop);
			conection.setAutoCommit(false);
			
	} 	catch (Exception e) {
			e.printStackTrace();
	}
}
	@Override
	public void insert(Order obj) throws SQLException {
		conectar();
		
		
		try {
		String query = "INSERT INTO livraria.order (user_id)" + "VALUES (?)";
		
		PreparedStatement prep = conection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		prep.setInt(1, obj.getUser().getId());
		
		prep.execute();
		conection.commit();
		conection.close();	
		} 
		catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	
	@Override
	public void mofify(Order obj) throws SQLException {
		conectar();
		
		try {
		String query = "UPDATE livraria.order" + "SET order_id = ? - ? WHERE order_id=?";
		
		PreparedStatement prep = conection.prepareStatement(query);
		
		
		prep.setInt(1, obj.getId());
		prep.setInt(2, obj.getBook().getQtde() - 1);
		prep.setInt(3, obj.getId());
		
		prep.execute();
		conection.commit();
		conection.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public void delete(Order obj) throws SQLException {
		conectar();
		
		try {
		String query = "DELETE FROM livraria.order" + "WHERE order_id=?";
		
		PreparedStatement prep = conection.prepareStatement(query);
		
		prep.setInt(1, obj.getId());
		
		prep.execute();
		conection.commit();
		conection.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	
	
	@Override
	public List show(Order obj) throws SQLException {
		conectar();
		
		ArrayList<String> lista = new ArrayList<String>();
		
		try {
		 String query = "SELECT * from livraria.order ";
		
		PreparedStatement prep= conection.prepareStatement (query);
		ResultSet lista1 = prep.executeQuery();
			
			while(lista1.next()) {
				Order order = new Order();
				order.getUser().getName();
				order.getBook().getTitle();
				order.getShippingInfo().getAdress();
				order.getBillingInfo().getAccount().getId();
				lista1.(obj);
			}
			
			prep.execute();
			conection.commit();
			conection.close();
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		return lista1;
	}

}
