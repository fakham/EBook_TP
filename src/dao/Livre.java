package dao;

public class Livre {
	private int id;
	private String description;
	private double prix, qtte;
	
	public Livre() {
		
	}
	
	public Livre(int id, String description, double prix, double qtte) {
		this.setId(id);
		this.setDescription(description);
		this.setPrix(prix);
		this.setQtte(qtte);
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public double getPrix() {
		return prix;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public double getQtte() {
		return qtte;
	}
	
	public void setQtte(double qtte) {
		this.qtte = qtte;
	}
	
	
}
