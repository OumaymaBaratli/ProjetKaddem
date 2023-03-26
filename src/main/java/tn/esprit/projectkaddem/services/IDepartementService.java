package tn.esprit.projectkaddem.services;

import tn.esprit.projectkaddem.entites.Departement;

import java.util.List;

public interface IDepartementService {
    List<Departement> getAllDepartement();
    Departement GetDepartementById(Integer id);
    void ajouteDepartement(Departement d);
    void updateDepartement(Departement d);
    void deleteDepartement(Integer id);
}
