package Livraria.dao;

import java.sql.SQLException;

import Livraria.Book;


public interface BookDaoImplements {
	
	void insert (Book obj) throws SQLException;
	void update (Book obj) throws SQLException;
	void delete (Book obj) throws SQLException;
	void show (Book obj) throws SQLException;
}
