package dev2426.ITSProjectWork.model;

import java.util.ArrayList;
import java.util.List;

public class TirocinioGUI {
	
	private String mansione;
	private String durata;
	private String nomeAzienda;
	private String descrizione;
	private long id_tirocinio;
	private List<Competenza> competenze = new ArrayList<>();

	public long getId_tirocinio() {
		return id_tirocinio;
	}

	public void setId_tirocinio(long id_tirocinio) {
		this.id_tirocinio = id_tirocinio;
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
	public String getNomeAzienda() {
		return nomeAzienda;
	}
	public void setNomeAzienda(String nomeAzienda) {
		this.nomeAzienda = nomeAzienda;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public TirocinioGUI() {

	}
	public List<Competenza> getCompetenze() {
		return competenze;
	}
	
	public void setCompetenze(List<Competenza>	competenze) {
		this.competenze = competenze;
	}
	
	public void addCompetenza(Competenza competenza) {
		this.competenze.add(competenza);
	}

}
