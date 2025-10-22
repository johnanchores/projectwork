package dev2426.ITSProjectWork.model;

public class CandidaturaGUI {

	private long id_candidatura;
	private String nomeUtente;
	private String cognomeUtente;
	private String mansioneTirocinio;
	private String nomeAzienda;
	private String stato;
	private String descrizioneTirocinio; 
	private String durataTirocinio;    
	private String orario_lavoro;

	public CandidaturaGUI(long id_candidatura, String nomeUtente, String cognomeUtente, String mansioneTirocinio,
			String nomeAzienda, String stato, String descrizioneTirocinio, String durataTirocinio,
			String orario_lavoro) {
		this.id_candidatura=id_candidatura;
		this.nomeAzienda = nomeAzienda;
		this.nomeUtente = nomeUtente;
		this.stato = stato;
		this.mansioneTirocinio = mansioneTirocinio;
		this.cognomeUtente=cognomeUtente;
		this.descrizioneTirocinio=descrizioneTirocinio;
		this.durataTirocinio=durataTirocinio;
		this.setOrario_lavoro(orario_lavoro);
	}

	public long getId_candidatura() {
		return id_candidatura;
	}

	public void setId_candidatura(long id_candidatura) {
		this.id_candidatura = id_candidatura;
	}

	public String getNomeUtente() {
		return nomeUtente;
	}

	public void setNomeUtente(String nomeUtente) {
		this.nomeUtente = nomeUtente;
	}

	public String getCognomeUtente() {
		return cognomeUtente;
	}

	public void setCognomeUtente(String cognomeUtente) {
		this.cognomeUtente = cognomeUtente;
	}

	public String getMansioneTirocinio() {
		return mansioneTirocinio;
	}

	public void setMansioneTirocinio(String mansioneTirocinio) {
		this.mansioneTirocinio = mansioneTirocinio;
	}

	public String getDescrizioneTirocinio() {
		return descrizioneTirocinio;
	}

	public void setDescrizioneTirocinio(String descrizioneTirocinio) {
		this.descrizioneTirocinio = descrizioneTirocinio;
	}

	public String getDurataTirocinio() {
		return durataTirocinio;
	}

	public void setDurataTirocinio(String durataTirocinio) {
		this.durataTirocinio = durataTirocinio;
	}

	public String getNomeAzienda() {
		return nomeAzienda;
	}

	public void setNomeAzienda(String nomeAzienda) {
		this.nomeAzienda = nomeAzienda;
	}

	public CandidaturaGUI() {

	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getOrario_lavoro() {
		return orario_lavoro;
	}

	public void setOrario_lavoro(String orario_lavoro) {
		this.orario_lavoro = orario_lavoro;
	}

}
