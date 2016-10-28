package MyCatalogue.sid.cat.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Produit")
public class Produit implements Serializable {
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String designation;
	
	private double prix;
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	//@JoinColumn(name="IdClient", nullable=true)
	private Client client;
		
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public double getPrix() {
		return prix;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Produit(Long id, String designation, double prix, Client client) {
		super();
		this.id = id;
		this.designation = designation;
		this.prix = prix;
		this.client = client;
	}

	public Produit() {
		super();
	}
	
	
	
	

}
