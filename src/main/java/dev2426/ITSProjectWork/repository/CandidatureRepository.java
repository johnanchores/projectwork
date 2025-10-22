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
               "   c.id_candidatura, " +        
               "   u.nome, " +                  
               "   u.cognome, " +               
               "   t.mansione, " +              
               "   a.nome, " +
               "   CASE c.stato " +
               "       WHEN 0 THEN 'In attesa' " +
               "       WHEN 1 THEN 'Accettata' " +
               "       WHEN 2 THEN 'Rifiutata' " +
               "       ELSE 'Sconosciuto' " +
               "   END, " +
               "   t.descrizione, " +
               "   t.durata, " +
               "   t.orario_lavoro) " +
               "FROM Candidatura c " +          
               "JOIN c.utente u " +              
               "JOIN c.tirocinio t " +           
               "JOIN t.azienda a")             
        List<CandidaturaGUI> findAllAsGUI();
    
    List<Candidatura> findByUtente(Utente utente);
    
	boolean existsByUtenteAndTirocinio(Utente utente, Tirocinio tirocinio);

}
