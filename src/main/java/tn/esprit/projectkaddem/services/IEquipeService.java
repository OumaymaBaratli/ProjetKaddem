package tn.esprit.projectkaddem.services;

import tn.esprit.projectkaddem.entites.Equipe;

import java.util.List;

public interface IEquipeService {
    List<Equipe> getAllEquipe();
    Equipe getEquipeById(Integer id);
    void ajouteEquipe(Equipe e);
    void updateEquipe(Equipe e);
    void deleteEquipe(Integer id);




}
