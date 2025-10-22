package dev2426.ITSProjectWork.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import dev2426.ITSProjectWork.model.Utente;
import dev2426.ITSProjectWork.model.UtenteGUI;
import dev2426.ITSProjectWork.repository.UtentiRepository;
import java.nio.file.Path;

@Service
public class UtentiService {

	@Autowired
	private UtentiRepository repo;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	public List<Utente> getAll() {
		
		return repo.findAll();	
	}
	
	public Optional<Utente> findId(long idCerca) {
		return repo.findById(idCerca);
	}
	
	public Optional<Utente> insert(UtenteGUI nuova) throws Exception {
		if(repo.existsByEmail(nuova.getEmail())) {
			return Optional.empty();
		}
		
		Utente u = new Utente();
		u.setNome(nuova.getNome());
		u.setCognome(nuova.getCognome());
		u.setEmail(nuova.getEmail());
        u.setPassword(passwordEncoder.encode(nuova.getPassword()));
        repo.save(u);
        return Optional.of(u);
    }

	
	public void delete(long idCancella) {
		repo.deleteById(idCancella);
	}
	
	public Optional<Utente> findByEmail(String email) {
		return repo.findByEmail(email);
	}
	
	public boolean update(long idUpdate, UtenteGUI datiNuovi) {
		Optional<Utente> optionalUtente = repo.findById(idUpdate);
        
        Utente utente = optionalUtente.get();
        utente.setNome(datiNuovi.getNome());
        utente.setCognome(datiNuovi.getCognome());
        
        if (datiNuovi.getPasswordNuova() != null && !datiNuovi.getPasswordNuova().isEmpty()) {
            if (passwordEncoder.matches(datiNuovi.getPassword(), utente.getPassword())) {
                utente.setPassword(passwordEncoder.encode(datiNuovi.getPasswordNuova()));
            }
            else {
                return false; 
            }
        }
        
        repo.save(utente);
        return true; 
    }

    public void saveCurriculumFile(long idUtente, MultipartFile file) throws IOException {
    
    // Definisci la directory di destinazione (DEVE ESISTERE!)
    // Ad esempio: una cartella "uploads/cvs" nella root del progetto o altrove.
    String uploadDir = "./uploads/cvs/"; 
    Path copyLocation = Paths.get(uploadDir + idUtente + "_" + file.getOriginalFilename());

    // Assicurati che la directory esista
    Files.createDirectories(copyLocation.getParent());
    
    // Copia il file nel percorso di destinazione
    Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);

    // 4. AGGIORNA IL PERCORSO NEL DATABASE
    Optional<Utente> optionalUtente = repo.findById(idUtente);
	if (optionalUtente.isPresent()) {
		Utente utente = optionalUtente.get();
		// Salva il nome del file o il percorso nel modello Utente
		utente.setCurriculumPath(copyLocation.toString());
		// utente.setCurriculumFileName(file.getOriginalFilename());
		repo.save(utente);
	}

}
}

