package Livraria;

public class Account {

	private String emailAdress;
	private long id;
	private String password;
	
	private long idTemp;
	private String passwordTemp;
	
	//metodos de operacao 
	
	public void setAccount(Account contaMika) {
		
	}


	public boolean verifyPassword() {
		
		if(password.equals(passwordTemp)) {
			return true;
		}
		return false;
	}
	
	
	public boolean validateLogin() {
		if(id == idTemp) {
			return true;
		}
		return false;
	}
	
	
	public boolean validateLogin(long id, String password) {
		
		idTemp = id;
		passwordTemp = password;
		return (validateLogin() && verifyPassword());	
	}
	
	
	//metodos acessores
	public String getEmailAdress() {
		return emailAdress;
	}
	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
