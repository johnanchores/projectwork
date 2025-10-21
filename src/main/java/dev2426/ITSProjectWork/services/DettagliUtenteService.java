package dev2426.ITSProjectWork.services;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import dev2426.ITSProjectWork.model.Utente;
import dev2426.ITSProjectWork.repository.UtentiRepository;

@Service
public class DettagliUtenteService implements UserDetailsService {
	
	@Autowired
	private UtentiRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Utente utente = repo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utente non trovato con email: " + email));
		
		return new User(
                utente.getEmail(),
                utente.getPassword(), 
                Collections.emptyList() //nessun ruolo
                );
	}

}
