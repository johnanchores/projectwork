package dev2426.ITSProjectWork.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev2426.ITSProjectWork.model.Candidatura;
import dev2426.ITSProjectWork.model.CandidaturaGUI;
import dev2426.ITSProjectWork.model.Utente;
import dev2426.ITSProjectWork.repository.CandidatureRepository;


@Service
public class CandidaturaService {
	
	@Autowired
	private CandidatureRepository repo;
	
	public List<Candidatura> getAll(){
		return repo.findAll();
	}
	
	public List<CandidaturaGUI> getAllCandGUI(){
		return repo.findAllAsGUI();
	}
	
	public void insert(Candidatura nuova) {
		if (repo.existsByUtenteAndTirocinio(nuova.getUtente(), nuova.getTirocinio())) {
            throw new IllegalStateException("Sei già candidato per questo tirocinio.");
        }
		repo.save(nuova);
	}
	
	public void delete(long idCancella) {
		repo.deleteById(idCancella);
	}
	
	public Optional<Candidatura> find(long idCerca){
		return repo.findById(idCerca);
	}
	
	public void updateCandi(long idUpdate, Candidatura nuova) {
		Optional<Candidatura> found = repo.findById(idUpdate);
		Candidatura c = found.get();
		
		c.setIdCandidatura(nuova.getIdCandidatura());
		c.setTirocinio(nuova.getTirocinio());
		c.setStato(nuova.getStato());
		
		repo.save(c);
	}
	
	public List<CandidaturaGUI> getUserCandidatureGui(Utente utente) {
        List<Candidatura> candidature = repo.findByUtente(utente);
        
        List<CandidaturaGUI> candidatureGUI = new ArrayList<>();

        for (Candidatura c : candidature) {
            CandidaturaGUI gui = new CandidaturaGUI();
            gui.setMansioneTirocinio(c.getTirocinio().getMansione());
            gui.setNomeAzienda(c.getTirocinio().getAzienda().getNome());
            gui.setDescrizioneTirocinio(c.getTirocinio().getDescrizione()); 
            gui.setDurataTirocinio(c.getTirocinio().getDurata());        

            switch (c.getStato()) {
                case 0: gui.setStato("In attesa"); break;
                case 1: gui.setStato("Accettata"); break;
                case 2: gui.setStato("Rifiutata"); break;
                default: gui.setStato("Sconosciuto");
            }
            
            candidatureGUI.add(gui);
        }
        
        return candidatureGUI;
    }

}
