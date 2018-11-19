package dao;

import java.util.ArrayList;

public class Cart_Livre {

	private int id;
	private Cart cart;
	private ArrayList<Livre> livres;
	
	public Cart_Livre() {
		this.livres = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Cart getCart() {
		return cart;
	}
	
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public ArrayList<Livre> getLivres() {
		return livres;
	}
	
	public void setLivres(ArrayList<Livre> livres) {
		this.livres = livres;
	}
	
}
