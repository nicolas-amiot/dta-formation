package fr.pizzeria.modele;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Performance {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ToString
	@Column(length = 255)
	private String service;
	
	private LocalDateTime dateMesure;
	
	private long tempsExec;
	
	public Performance(String service, LocalDateTime dateMesure, long tempsExec) {
		this.service = service;
		this.dateMesure = dateMesure;
		this.tempsExec = tempsExec;
	}
	
	public Performance(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public LocalDateTime getDateMesure() {
		return dateMesure;
	}

	public void setDateMesure(LocalDateTime dateMesure) {
		this.dateMesure = dateMesure;
	}

	public long getTempsExec() {
		return tempsExec;
	}

	public void setTempsExec(long tempsExec) {
		this.tempsExec = tempsExec;
	}

}
