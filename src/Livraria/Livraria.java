package Livraria;

import java.util.Scanner;

public class Livraria {

	public static void main(String[] args) {
		
		//criar livro
		Book Aladdin = new Book();
		
		//criar autor | vincular autor ao livro
		Author JordanM = new Author();
		Aladdin.setAutor(JordanM);
		
		//criar um publicador | vincular ao livro
		Publisher Rocco = new Publisher();
		Aladdin.setPublisher(Rocco);
		
		//criar usuario editorial | criar usuario consumidor
		User mika = new User();
		User john = new Customer();
		User sam = new Editorial();
		
		//criar entregador | criar informação de entrega | vincular informacao de entrega ao entregador
		Shipper entregador = new Shipper();
		ShippingInfo infoEntrega = new ShippingInfo();
		infoEntrega.setShipper(entregador);
		
		//criar uma conta
		Account contaMika = new Account();
		contaMika.setAccount(contaMika);
		contaMika.setId(2);
		contaMika.setPassword("321");
		contaMika.setEmailAdress("mika@email.com");
		
		//informações de compra
		BillingInfo infoCompra = new BillingInfo();
		infoCompra.setAccount(contaMika);
		
		//criar ordem de compra | vincular com usuario | verificar se todos os dados foram preenchidos
		Order compra1 = new Order();
		compra1.setUser(mika);
		compra1.setBook(Aladdin);
		compra1.setBillingInfo(infoCompra);
		compra1.setShippingInfo(infoEntrega);
		
		if(compra1.isFullFilled()) {
			Scanner scannerId;
			Scanner scannerPassword;
			int id = 0;
			String pass = "";
			
			try {
				scannerId = new Scanner(System.in);
				scannerPassword = new Scanner(System.in);
				
				System.out.println("Digite seu id: ");
				id = scannerId.nextInt();
				
				System.out.println("Digite sua senha: ");
				pass = scannerPassword.next();	
			} catch(Exception e){	
				e.printStackTrace();
			}
			if(compra1.getBillingInfo().getAccount().validateLogin(id, pass)) {
				System.out.println("Compra realizada com sucesso! ");
			}
			
		}
		
	}

}
