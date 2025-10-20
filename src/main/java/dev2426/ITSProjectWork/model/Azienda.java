package dev2426.ITSProjectWork.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "azienda")
public class Azienda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_azienda;
	private String nome;
	private String localita;
	private String partitaIva;
	private long id_tirocinio;
	
	public long getIdAzienda() {
		return id_azienda;
	}
	public void setIdAzienda(long idAzienda) {
		this.id_azienda = idAzienda;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocalita() {
		return localita;
	}
	public void setLocalita(String localita) {
		this.localita = localita;
	}
	public String getPartitaIva() {
		return partitaIva;
	}
	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}
	public long getIdTirocinio() {
		return id_tirocinio;
	}
	public void setIdTirocinio(long idTirocinio) {
		this.id_tirocinio = idTirocinio;
	}
	public Azienda(long idAzienda, String nome, String localita, String partitaIva, long idTirocinio) {
		this.id_azienda = idAzienda;
		this.nome = nome;
		this.localita = localita;
		this.partitaIva = partitaIva;
		this.id_tirocinio = idTirocinio;
	}
	public Azienda() {
		
	}

}
