package dev2426.ITSProjectWork.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "candidatura")
public class Candidatura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_candidatura;
	private long id_tirocinio;
	private int stato;
	private String orarioLavoro;
	private long id_utente;
	
	public long getIdCandidatura() {
		return id_candidatura;
	}
	public void setIdCandidatura(long idCandidatura) {
		this.id_candidatura = idCandidatura;
	}
	public long getIdTirocinio() {
		return id_tirocinio;
	}
	public void setIdTirocinio(long idTirocinio) {
		this.id_tirocinio = idTirocinio;
	}
	public int getStato() {
		return stato;
	}
	public void setStato(int stato) {
		this.stato = stato;
	}
	public String getOrarioLavoro() {
		return orarioLavoro;
	}
	public void setOrarioLavoro(String orarioLavoro) {
		this.orarioLavoro = orarioLavoro;
	}
	public Candidatura(long idCandidatura, long idTirocinio, int stato, String orarioLavoro, long idUtente) {
		this.id_candidatura = idCandidatura;
		this.id_tirocinio = idTirocinio;
		this.stato = stato;
		this.orarioLavoro = orarioLavoro;
		this.id_utente = idUtente;
	}
	public Candidatura() {

	}
	public long getId_utente() {
		return id_utente;
	}
	public void setId_utente(long id_utente) {
		this.id_utente = id_utente;
	}
		
}
