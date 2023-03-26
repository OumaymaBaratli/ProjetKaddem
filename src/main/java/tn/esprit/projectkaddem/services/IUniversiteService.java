package tn.esprit.projectkaddem.services;

import tn.esprit.projectkaddem.entites.Departement;
import tn.esprit.projectkaddem.entites.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> getAllUniversite();
    Universite getUniversiteById(Integer id);
    void ajouteUniversite(Universite u);
    void updateUniversite(Universite u);
    void deleteUniversite(Integer id);
     void assignUniversiteToDepartement(Integer idUniversite, Integer
            idDepartement);
     List<Departement> retrieveDepartementsByUniversite(Integer idUniversite);

}
