package dev2426.ITSProjectWork.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tirocinio")
public class Tirocinio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_tirocinio;
	private String mansione;
	private String durata;
	private String descrizione;
	
	@ManyToOne
	@JoinColumn(name = "id_azienda") 
	private Azienda azienda;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
		name = "comp_tir", 
		joinColumns = @JoinColumn(name = "id_tirocinio"), 
		inverseJoinColumns = @JoinColumn(name = "id_competenza") 
	)
	private List<Competenza> competenze;
	
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

	public Tirocinio() {

	}
	
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public Azienda getAzienda() {
		return azienda;
	}
	public void setAzienda(Azienda azienda) {
		this.azienda = azienda;
	}
	public List<Competenza> getCompetenze() {
		return competenze;
	}
	public void setCompetenze(List<Competenza> competenze) {
		this.competenze = competenze;
	}
	
	public long getIdTirocinio() {
		return id_tirocinio; 
	}
	public void setIdTirocinio(long idTirocinio) {
		this.id_tirocinio = idTirocinio;
	}
}


