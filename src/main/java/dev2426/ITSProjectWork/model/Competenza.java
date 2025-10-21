package dev2426.ITSProjectWork.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "competenza") 
public class Competenza {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_competenza;
    private String nome;

    @ManyToMany(mappedBy = "competenze")
    private List<Tirocinio> tirocini;
    
    public long getIdCompetenza() {
        return id_competenza;
    }
    public void setIdCompetenza(long idCompetenza) {
        this.id_competenza = idCompetenza;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Competenza(long idCompetenza, String nome) {
        this.id_competenza = idCompetenza;
        this.nome = nome;
    }
    public Competenza() {
        
    }
    public List<Tirocinio> getTirocini() {
        return tirocini;
    }
    public void setTirocini(List<Tirocinio> tirocini) {
        this.tirocini = tirocini;
    }
    
}
