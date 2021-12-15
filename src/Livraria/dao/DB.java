package Livraria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	public void create() throws SQLException {
       
        Properties configuracaoConexao = new Properties();
        configuracaoConexao.setProperty("user", "root");
        configuracaoConexao.setProperty("password", "123");
        
        try (Connection conection = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/livraria", configuracaoConexao)) {

        	conection.setAutoCommit(false);

            try (Statement statement = conection.createStatement()) {
            	statement.execute(
                        "CREATE TABLE IF NOT EXISTS livraria.user ("
                        + "id INT PRIMARY KEY AUTO_INCREMENT,"
                        + "name VARCHAR(25)"	
                        + "constraint name foreign key references BaseName(name)"
                        + "ENGINE=InnoDB;");
            } catch (Exception e) {
                e.printStackTrace();
            }

            
            try (Statement statement = conection.createStatement()) {
            	statement.execute(
                        "CREATE TABLE IF NOT EXISTS livraria.publisher ("
                        + "id INT PRIMARY KEY AUTO_INCREMENT,"
                        + "name VARCHAR(25)"
                        + "constraint name foreign key references BaseName(name)"
                        + "ENGINE=InnoDB;");
            } catch (Exception e) {
                e.printStackTrace();
            }

         
            try (Statement statement = conection.createStatement()) {
            	statement.execute(
                        "CREATE TABLE IF NOT EXISTS livraria.author ("
                        + "id INT PRIMARY KEY AUTO_INCREMENT,"
                        + "name VARCHAR(25))"
                        + "constraint name foreign key references BaseName(name)"
                        + "ENGINE=InnoDB;");
            } catch (Exception e) {
                e.printStackTrace();
            }

           
            try (Statement statement = conection.createStatement()) {
            	statement.execute(
                        "CREATE TABLE IF NOT EXISTS livraria.book ("
                        + "id INT PRIMARY KEY AUTO_INCREMENT,"
                        + "qtde INT "		
                        + "title VARCHAR(25),"
                        + "nameAuthor VARCHAR(25),"
                        + "constraint nameAuthor foreign key references BaseName(name)"
                        + "namePublisher VARCHAR(25),"
                        + "constraint namePublisher foreign key references BaseName(name)"
                        + "ENGINE=InnoDB;");
            } catch (Exception e) {
                e.printStackTrace();
            }

  
            
            try (Statement statement = conection.createStatement()) {
            	statement.execute(
                        "CREATE TABLE IF NOT EXISTS livraria.order ("
                        + "id INT PRIMARY KEY AUTO_INCREMENT,"
                        + "title VARCHAR(25)"
                        + "idBook INT,"
                        + "CONSTRAINT idBook FOREIGN KEY REFERENCES book(idBook),"
                        + "idShipping INT,"
                        + "CONSTRAINT idShipping FOREIGN KEYREFERENCES ShippingInfo (id),"
                        + "idBilling INT,"
                        + "CONSTRAINT idBilling FOREIGN KEY REFERENCES BillingInfo (id),"
                        + "idUser INT,"
                        + "CONSTRAINT idUser FOREIGN KEY REFERENCES User (idUser),"
                        + "ENGINE=InnoDB;");
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            
            try (Statement statement = conection.createStatement()) {
            	statement.execute(
                        "CREATE TABLE IF NOT EXISTS livraria.account ("
                        + "id INT PRIMARY KEY AUTO_INCREMENT,"	
                        + "password VARCHAR(25),"
                        + "email VARCHAR(25),"
                        + "ENGINE=InnoDB;");
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            try (Statement statement = conection.createStatement()) {
            	statement.execute(
                        "CREATE TABLE IF NOT EXISTS livraria.billingInfo ("
                        + "id INT PRIMARY KEY AUTO_INCREMENT,"	
                        + "idAccount INT,"
                        + "CONSTRAINT idAccount FOREIGN KEY REFERENCES account(id),"
                        + "ENGINE=InnoDB;");
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            try (Statement statement = conection.createStatement()) {
            	statement.execute(
                        "CREATE TABLE IF NOT EXISTS livraria.customer ("
                        + "id INT PRIMARY KEY AUTO_INCREMENT,"	
                        + "idUser INT,"
                        + "CONSTRAINT idUser FOREIGN KEY REFERENCES user(id),"
                        + "ENGINE=InnoDB;");
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            try (Statement statement = conection.createStatement()) {
            	statement.execute(
                        "CREATE TABLE IF NOT EXISTS livraria.customerReview ("
                        + "id INT PRIMARY KEY AUTO_INCREMENT,"	
                        + "idReview INT,"
                        + "CONSTRAINT idReview FOREIGN KEY REFERENCES review(id),"
                        + "ENGINE=InnoDB;");
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            try (Statement statement = conection.createStatement()) {
            	statement.execute(
                        "CREATE TABLE IF NOT EXISTS livraria.editorial ("
                        + "id INT PRIMARY KEY AUTO_INCREMENT,"	
                        + "idUser INT,"
                        + "CONSTRAINT idUser FOREIGN KEY REFERENCES user(id),"
                        + "ENGINE=InnoDB;");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
	}
}
