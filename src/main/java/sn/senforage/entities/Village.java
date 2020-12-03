package sn.senforage.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Village implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	@OneToMany(mappedBy ="village",fetch = FetchType.LAZY)
	private List<Client>clients=new ArrayList<Client>();
	@ManyToOne
	@JoinColumn(name = "idU")
	private User user = new User();
	
	public Village() {
		super();
	}
	public Village(int id, String nom, List<Client> clients, User user) {
		super();
		this.id = id;
		this.nom = nom;
		this.clients = clients;
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
