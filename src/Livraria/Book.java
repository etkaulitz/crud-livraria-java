package Livraria;

public class Book {

	private String title;
	Author autor;
	Publisher publisher;
	private int id;
	private int qtde;
	
	
	
	public int getQtde() {
		return qtde;
	}
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Author getAutor() {
		return autor;
	}
	public void setAutor(Author autor) {
		this.autor = autor;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
}
