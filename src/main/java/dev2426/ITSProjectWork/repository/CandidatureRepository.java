package dev2426.ITSProjectWork.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dev2426.ITSProjectWork.model.Candidatura;
import dev2426.ITSProjectWork.model.CandidaturaGUI;
import dev2426.ITSProjectWork.model.Tirocinio;
import dev2426.ITSProjectWork.model.Utente;

@Repository
public interface CandidatureRepository extends JpaRepository<Candidatura, Long> {

	@Query("SELECT new dev2426.ITSProjectWork.model.CandidaturaGUI(" +
			"   c.id_candidatura, c.utente.nome, c.utente.cognome, " +
			"   c.tirocinio.mansione, c.tirocinio.descrizione, " +
			"   c.tirocinio.azienda.nome, c.stato) " +
			"FROM Candidatura c")
	List<CandidaturaGUI> findAllAsGUI();

	List<Candidatura> findByUtente(Utente utente);

	public abstract boolean existsByUtenteAndTirocinio(Utente utente, Tirocinio tirocinio);

}
