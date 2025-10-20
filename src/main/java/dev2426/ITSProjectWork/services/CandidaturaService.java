package dev2426.ITSProjectWork.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev2426.ITSProjectWork.model.Candidatura;
import dev2426.ITSProjectWork.repository.CandidatureRepository;

@Service
public class CandidaturaService {
	
	@Autowired
	private CandidatureRepository repo;
	
	public List<Candidatura> getAll(){
		return repo.findAll();
	}
	
	public void insert(Candidatura nuova) {
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
		c.setIdTirocinio(nuova.getIdTirocinio());
		c.setOrarioLavoro(nuova.getOrarioLavoro());
		c.setStato(nuova.getStato());
		
		repo.save(c);
	}
	
	

}
