package Livraria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import Livraria.Book;

public class BookDao implements BookDaoImplements{

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
	
	public void delete(Book obj) throws SQLException  {
		conectar();
		
		
		try {
		String query = "DELETE FROM livraria.book" + "WHERE id = ?";
		
		PreparedStatement prep = conection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		prep.setInt(1, obj.getId());
		
		prep.execute();
		conection.commit();
		conection.close();	
		} 
		catch (Exception e) {
		e.printStackTrace();
		}
	}

	@Override
	public void insert(Book obj) throws SQLException {
		conectar();
		
		
		try {
		String query = "INSERT INTO livraria.book" + "(title, autor,  publisher)" + "VALUES (?, ?, ?)";
		
		PreparedStatement prep = conection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
		
		prep.setString(1, obj.getTitle());
		prep.setObject(2, obj.getAutor());
		prep.setObject(3, obj.getPublisher());
		
		prep.execute();
		conection.commit();
		conection.close();	
		} 
		catch (Exception e) {
		e.printStackTrace();
		}
	}
		

	@Override
	public void update(Book obj) throws SQLException {
		conectar();
		
		try {
		String query = "UPDATE livraria.book" 
						+ "SET title = ? WHERE id=?";
		
		PreparedStatement prep= conection.prepareStatement (query);
		
		prep.setString(1, obj.getTitle());
		prep.setInt(2,  obj.getId());
		
		prep.execute();
		conection.commit();
		conection.close();
		
		} catch (SQLException e){
			e.printStackTrace();
			
		}
		
	}

	@Override
	public void show(Book obj) throws SQLException {
		conectar();
		
		try {
		String query = "SELECT * from livraria.book ";
		
		PreparedStatement prep= conection.prepareStatement (query);
		
		prep.setString(1, obj.getTitle());
		
		prep.execute();
		conection.commit();
		conection.close();
		
		}
		
		catch (SQLException e){
			e.printStackTrace();
		}
	}		
}
