package Livraria.dao;

import java.awt.List;
import java.sql.SQLException;

import Livraria.Author;

public interface AutorDaoImplements {
	void insert (Author obj) throws SQLException;
	void update (Author obj) throws SQLException;
	void delete (Author obj) throws SQLException;
	void show (Author obj) throws SQLException;

	
}
