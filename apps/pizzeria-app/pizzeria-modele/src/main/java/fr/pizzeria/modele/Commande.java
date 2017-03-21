package fr.pizzeria.modele;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Commande implements Serializable {
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private Integer id;
	
	@Column(length = 255)
	private String numero;
	
	private Integer statut;
	
	private Date dateCommande;
	
	@ManyToOne
	@JoinColumn(name = "idLivreur")
	private Livreur livreur;
	
	@ManyToOne
	@JoinColumn(name = "idClient")
	private Client client;
	
	@OneToMany
	private List<CommandePizza> commandePizzas;
	
	public Commande() {
		
	}
	
	public Commande(String numero, Integer statut, Date dateCommande, Livreur livreur, Client client, List<CommandePizza> commandePizzas) {
		this.numero = numero;
		this.statut = statut;
		this.dateCommande = dateCommande;
		this.livreur = livreur;
		this.client = client;
		this.commandePizzas = commandePizzas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getStatut() {
		return statut;
	}

	public void setStatut(Integer statut) {
		this.statut = statut;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Livreur getLivreur() {
		return livreur;
	}

	public void setLivreur(Livreur livreur) {
		this.livreur = livreur;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<CommandePizza> getCommandePizzas() {
		return commandePizzas;
	}

	public void setCommandePizzas(List<CommandePizza> commandePizzas) {
		this.commandePizzas = commandePizzas;
	}

}
