package MyCatalogue.sid.cat.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Client")
public class Client implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="IdClient")
	private Long id;
	
	private String nom;
	
	private String prenom;
	
	private String adrresse;
	
	
	//@Column(name="nomProduit")
	@OneToMany(fetch=FetchType.LAZY, mappedBy="client")
	@JsonIgnore
	private Set<Produit> produit = new HashSet<Produit>(0);

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getAdrresse() {
		return adrresse;
	}

	public void setAdrresse(String adrresse) {
		this.adrresse = adrresse;
	}

	public Set<Produit> getProduit() {
		return produit;
	}

	public void setProduit(Set<Produit> produit) {
		this.produit = produit;
	}

	public Client(Long id, String nom, String prenom, String adrresse, Set<Produit> produit) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adrresse = adrresse;
		this.produit = produit;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
