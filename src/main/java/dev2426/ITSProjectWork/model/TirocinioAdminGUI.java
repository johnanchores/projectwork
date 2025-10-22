package dev2426.ITSProjectWork.model;

import java.util.List;

public class TirocinioAdminGUI {

    private String mansione; 
    private String durata;
    private String orari; 
    private String descrizione;
    private Long aziendaId;
    private List<Long> competenzeId;
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
	public String getOrari() {
		return orari;
	}
	public void setOrari(String orari) {
		this.orari = orari;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Long getAziendaId() {
		return aziendaId;
	}
	public void setAziendaId(Long aziendaId) {
		this.aziendaId = aziendaId;
	}
	public List<Long> getCompetenzeId() {
		return competenzeId;
	}
	public void setCompetenzeId(List<Long> competenzeId) {
		this.competenzeId = competenzeId;
	}
	public TirocinioAdminGUI() {
		
	}

}