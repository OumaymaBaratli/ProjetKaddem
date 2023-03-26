package tn.esprit.projectkaddem.services;

import tn.esprit.projectkaddem.entites.DetailEquipe;

import java.util.List;

public interface IDetailEquipeService {

    List<DetailEquipe> getAllDetailEquipe();
    DetailEquipe getDetailEquipeById(Integer id);
    void  ajouteDetailEquipe(DetailEquipe d);
    void updateDetailEquipe(DetailEquipe d);
    void deleteDetailEquipe(Integer id);

}
