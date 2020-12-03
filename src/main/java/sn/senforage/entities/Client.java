package sn.senforage.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Client implements Serializable{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column
private String nom;
@Column
private String prenom;
@Column
private String telephone;
@Column
private String adresse;
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "idV")
private Village village= new Village();
@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "idU")
private User user =new User();

public Client() {
	super();
}
public Client(int id, String nom, String prenom, String telephone, String adresse, Village village, User user) {
	super();
	this.id = id;
	this.nom = nom;
	this.prenom = prenom;
	this.telephone = telephone;
	this.adresse = adresse;
	this.village = village;
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
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public Village getVillage() {
	return village;
}
public void setVillage(Village village) {
	this.village = village;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}


}
