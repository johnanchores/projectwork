package dev2426.ITSProjectWork.model;

import java.util.List;

public class TirocinioGUI {
	
	private String mansione;
	private String durata;
	private String nomeAzienda;
	private String descrizione;
	private List<Long> competenze;
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
	public List<Long> getCompetenze() {
		return competenze;
	}
	public void setCompetenze(List<Long> competenze) {
		this.competenze = competenze;
	}

}
