package dao;

public class Cart {
	
	private int id;
	private Client client;
	
	public Cart(int id, Client client) {
		this.id = id;
		this.client = client;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
}
