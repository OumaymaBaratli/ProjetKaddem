package tn.esprit.projectkaddem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.projectkaddem.entites.Departement;

public interface DepartementRepository extends JpaRepository<Departement,Integer> {
}
