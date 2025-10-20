package dev2426.ITSProjectWork.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev2426.ITSProjectWork.model.Competenza;
import dev2426.ITSProjectWork.repository.CompetenzeRepository;

@Service
public class CompetenzaService {
	
	@Autowired
	private CompetenzeRepository repo;
	
	public List<Competenza> getAll() {
		
		return repo.findAll();
				
	}
	
	public Optional<Competenza> find(long idCerca) {
		return repo.findById(idCerca);
	}
	
	public void insert(Competenza nuova) {
		
		repo.save(nuova);
		
	}
	
	public void delete(long idCancella) {
		repo.deleteById(idCancella);
	}
	
	public void updateComp(long idUpdate, Competenza nuova) {

		Optional<Competenza> compCerca = repo.findById(idUpdate);
		Competenza c = compCerca.get();

		c.setIdCompetenza(nuova.getIdCompetenza());
		c.setNome(nuova.getNome());
		
		repo.save(c);

	}	

}
