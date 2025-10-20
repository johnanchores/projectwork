package dev2426.ITSProjectWork.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev2426.ITSProjectWork.model.Azienda;
import dev2426.ITSProjectWork.repository.AziendeRepository;

@Service
public class AziendaService {

	@Autowired
	private AziendeRepository repo;

	public List<Azienda> getAll() {
		return repo.findAll();
	}

	public void insert(Azienda nuova) {
		repo.save(nuova);
	}

	public void deleteAzienda(long idCancella) {
		repo.deleteById(idCancella);
	}

	public Optional<Azienda> find(long idCerca) {
		return repo.findById(idCerca);
	}

	public void update(Azienda nuova, long idUpdate) {
		Optional<Azienda> found = repo.findById(idUpdate);
		Azienda a = found.get();
		a.setIdAzienda(nuova.getIdAzienda());
		a.setLocalita(nuova.getLocalita());
		a.setNome(nuova.getNome());
		a.setPartitaIva(nuova.getPartitaIva());
		repo.save(a);
	}

}
