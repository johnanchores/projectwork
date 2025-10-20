package dev2426.ITSProjectWork.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev2426.ITSProjectWork.model.Competenza;

@Repository
public interface CompetenzeRepository extends JpaRepository<Competenza, Long> {

}
