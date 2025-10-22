package dev2426.ITSProjectWork.model;

import org.springframework.web.multipart.MultipartFile;

public class UtenteGUI {
	
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private String passwordNuova;
	private String confermaPassword;
	private MultipartFile curriculumFile;

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
	
	public UtenteGUI(){
		
	}
	public String getConfermaPassword() {
		return confermaPassword;
	}
	public void setConfermaPassword(String confermaPassword) {
		this.confermaPassword = confermaPassword;
	}
	public String getPasswordNuova() {
		return passwordNuova;
	}

	public void setPasswordNuova(String passwordNuova) {
		this.passwordNuova = passwordNuova;
	}
	
	public MultipartFile getCurriculumFile() {
        return curriculumFile;
    }

    public void setCurriculumFile(MultipartFile curriculumFile) {
        this.curriculumFile = curriculumFile;
    }

}
