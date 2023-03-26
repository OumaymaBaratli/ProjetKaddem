package tn.esprit.projectkaddem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projectkaddem.entites.Contrat;
import tn.esprit.projectkaddem.entites.Etudiant;

import java.util.Date;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat,Integer> {
   List<Contrat> findByDateDebutContratLessThanEqualAndDateFinContratGreaterThanEqualAndArchiveIsFalse(Date startDate, Date endDate);
}
