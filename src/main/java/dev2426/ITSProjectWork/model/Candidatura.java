package dev2426.ITSProjectWork.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "candidatura")
public class Candidatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_candidatura;
	
	@ManyToOne
	@JoinColumn(name = "id_tirocinio")
	private Tirocinio tirocinio;
	
	@ManyToOne
	@JoinColumn(name = "id_utente")
	private Utente utente;
	
	private int stato;
	
	public long getIdCandidatura() {
		return id_candidatura;
	}
	public void setIdCandidatura(long idCandidatura) {
		this.id_candidatura = idCandidatura;
	}
	
	public int getStato() {
		return stato;
	}
	public void setStato(int stato) {
		this.stato = stato;
	}
	public Candidatura() {

	}
	
	public Tirocinio getTirocinio() {
        return tirocinio;
    }
	
    public void setTirocinio(Tirocinio tirocinio) {
        this.tirocinio = tirocinio;
    }
    
    public Utente getUtente() {
        return utente;
    }
	
    public void setUtente(Utente utente) {
        this.utente = utente;
    }
		
}
