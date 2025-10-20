package dev2426.ITSProjectWork.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev2426.ITSProjectWork.model.Utente;

@Repository
public interface UtentiRepository extends JpaRepository<Utente, Long> {
	
	Optional<Utente> findByEmail(String email);
	
	boolean existsByEmail(String email);

}
