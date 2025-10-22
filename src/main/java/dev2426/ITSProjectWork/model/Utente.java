package dev2426.ITSProjectWork.model;

import jakarta.persistence.Column; // Import aggiunto per l'annotazione @Column
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "utente")
public class Utente {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_utente; 
    
    private String nome;
    private String cognome;
    private String email;
    private String password;
    @Column(name = "curriculum_path")
    private String curriculumPath;
    
    private String ruolo;

    public long getIdUtente() {
        return id_utente;
    }

    public void setIdUtente(long idUtente) {
        this.id_utente = idUtente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getCurriculumPath() {
        return curriculumPath;
    }

    public void setCurriculumPath(String curriculumPath) {
        this.curriculumPath = curriculumPath;
    }
    
    public String getStato() {
        return ruolo;
    }

    public void setStato(String stato) {
        this.ruolo = stato;
    }

    public Utente(long idUtente, String nome, String cognome, String email, String password, String curriculumPath) {
        super();
        this.id_utente = idUtente;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.password = password;
        this.curriculumPath = curriculumPath;
        this.ruolo = "ATTIVO"; 
    }

    public Utente() {
        
    }
}