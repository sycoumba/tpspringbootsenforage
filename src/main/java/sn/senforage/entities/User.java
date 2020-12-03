package sn.senforage.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String email;
	@Column
	private String password;
	
@OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
	private List<Client>clients = new ArrayList<Client>();
@OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
	private List<Village>villages =new ArrayList<Village>();
@ManyToMany
private List<Roles>roles=new ArrayList<Roles>();

public User() {
	super();
}
public User(int id, String nom, String prenom, String email, String password, List<Client> clients,
		List<Village> villages) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.email = email;
	this.password = password;
	this.clients = clients;
	this.villages = villages;
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
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public List<Client> getClients() {
	return clients;
}
public void setClients(List<Client> clients) {
	this.clients = clients;
}
public List<Village> getVillages() {
	return villages;
}
public void setVillages(List<Village> villages) {
	this.villages = villages;
}

}
