package tn.esprit.projectkaddem.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.projectkaddem.entites.DetailEquipe;
import tn.esprit.projectkaddem.repositories.DetailEquipeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IDetailEquipeServiceImp implements IDetailEquipeService{
    private final DetailEquipeRepository detailEquipeRepository;
    @Override
    public List<DetailEquipe> getAllDetailEquipe() {
        return detailEquipeRepository.findAll();
    }

    @Override
    public DetailEquipe getDetailEquipeById(Integer id) {
        return detailEquipeRepository.findById(id).orElse(null);
    }

    @Override
    public void ajouteDetailEquipe(DetailEquipe d) {
        detailEquipeRepository.save(d);
    }

    @Override
    public void updateDetailEquipe(DetailEquipe d) {
        detailEquipeRepository.save(d);
    }

    @Override
    public void deleteDetailEquipe(Integer id) {
        detailEquipeRepository.deleteById(id);
    }
}
