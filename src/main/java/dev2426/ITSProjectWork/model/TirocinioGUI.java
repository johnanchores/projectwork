package dev2426.ITSProjectWork.model;

import java.util.List;
import java.util.Objects;

public class TirocinioGUI {
	
	private String mansione;
	private String durata;
	private String nomeAzienda;
	private String descrizione;
	private List<Long> competenze;
	private List<String> nome_competenza;
	private Long id_tirocinio;


	public TirocinioGUI() {
	}

	public TirocinioGUI(String mansione, String durata, String nomeAzienda, String descrizione, List<Long> competenze, List<String> nome_competenza, Long id_tirocinio) {
		this.mansione = mansione;
		this.durata = durata;
		this.nomeAzienda = nomeAzienda;
		this.descrizione = descrizione;
		this.competenze = competenze;
		this.nome_competenza = nome_competenza;
		this.id_tirocinio = id_tirocinio;
	}

	public String getMansione() {
		return this.mansione;
	}

	public void setMansione(String mansione) {
		this.mansione = mansione;
	}

	public TirocinioGUI mansione(String mansione) {
		setMansione(mansione);
		return this;
	}

	public String getDurata() {
		return this.durata;
	}

	public void setDurata(String durata) {
		this.durata = durata;
	}

	public TirocinioGUI durata(String durata) {
		setDurata(durata);
		return this;
	}

	public String getNomeAzienda() {
		return this.nomeAzienda;
	}

	public void setNomeAzienda(String nomeAzienda) {
		this.nomeAzienda = nomeAzienda;
	}

	public TirocinioGUI nomeAzienda(String nomeAzienda) {
		setNomeAzienda(nomeAzienda);
		return this;
	}

	public String getDescrizione() {
		return this.descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public TirocinioGUI descrizione(String descrizione) {
		setDescrizione(descrizione);
		return this;
	}

	public List<Long> getCompetenze() {
		return this.competenze;
	}

	public void setCompetenze(List<Long> competenze) {
		this.competenze = competenze;
	}

	public TirocinioGUI competenze(List<Long> competenze) {
		setCompetenze(competenze);
		return this;
	}

	public List<String> getNome_competenza() {
		return this.nome_competenza;
	}

	public Long getId_tirocinio() {
		return this.id_tirocinio;
	}

	public void setId_tirocinio(Long id_tirocinio) {
		this.id_tirocinio = id_tirocinio;
	}

	public TirocinioGUI id_tirocinio(Long id_tirocinio) {
		setId_tirocinio(id_tirocinio);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof TirocinioGUI)) {
			return false;
		}
		TirocinioGUI tirocinioGUI = (TirocinioGUI) o;
		return Objects.equals(mansione, tirocinioGUI.mansione) && Objects.equals(durata, tirocinioGUI.durata) && Objects.equals(nomeAzienda, tirocinioGUI.nomeAzienda) && Objects.equals(descrizione, tirocinioGUI.descrizione) && Objects.equals(competenze, tirocinioGUI.competenze) && Objects.equals(nome_competenza, tirocinioGUI.nome_competenza) && Objects.equals(id_tirocinio, tirocinioGUI.id_tirocinio);
	}

	@Override
	public int hashCode() {
		return Objects.hash(mansione, durata, nomeAzienda, descrizione, competenze, nome_competenza, id_tirocinio);
	}

	@Override
	public String toString() {
		return "{" +
			" mansione='" + getMansione() + "'" +
			", durata='" + getDurata() + "'" +
			", nomeAzienda='" + getNomeAzienda() + "'" +
			", descrizione='" + getDescrizione() + "'" +
			", competenze='" + getCompetenze() + "'" +
			", nome_competenza='" + getNome_competenza() + "'" +
			", id_tirocinio='" + getId_tirocinio() + "'" +
			"}";
	}
	
	public void setNome_competenza(String nome_competenza) {
		this.nome_competenza.add(nome_competenza);
	}

}
