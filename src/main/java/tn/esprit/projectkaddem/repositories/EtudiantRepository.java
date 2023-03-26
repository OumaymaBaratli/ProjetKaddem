package tn.esprit.projectkaddem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projectkaddem.entites.Etudiant;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant,Integer> {

    Etudiant findByNomEAndPrenomE(String nomE, String prenomE);
    List<Etudiant> findByDepartementIdDepart(Integer idDepart);
}
