package dev2426.ITSProjectWork.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tirocinio")
public class Tirocinio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_tirocinio;
	private String mansione;
	private String durata;
	private long id_azienda;
	private String descrizione;
	
	public long getIdTirocinio() {
		return id_tirocinio;
	}
	public void setIdTirocinio(long idTirocinio) {
		this.id_tirocinio = idTirocinio;
	}
	public String getMansione() {
		return mansione;
	}
	public void setMansione(String mansione) {
		this.mansione = mansione;
	}
	public String getDurata() {
		return durata;
	}
	public void setDurata(String durata) {
		this.durata = durata;
	}
	public Tirocinio(long idTirocinio, String mansione, String durata, long idAzienda, String descrizione) {
		this.id_tirocinio = idTirocinio;
		this.mansione = mansione;
		this.durata = durata;
		this.id_azienda = idAzienda;
		this.descrizione = descrizione;
	}
	public Tirocinio() {

	}
	public long getId_azienda() {
		return id_azienda;
	}
	public void setId_azienda(long id_azienda) {
		this.id_azienda = id_azienda;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
}
